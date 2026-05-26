package in.edu.kristujayanti.util;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.ReadStream;
import java.io.IOException;
import java.io.InputStream;

public class VertxAsyncInputStreamUtil implements ReadStream<Buffer> {
    private final Vertx vertx;
    private final InputStream inputStream;
    private static final int BUFFER_SIZE = 8192;
    private Handler<Buffer> dataHandler;
    private Handler<Void> endHandler;
    private Handler<Throwable> exceptionHandler;
    private boolean reading = false;
    private boolean ended = false;

    public VertxAsyncInputStreamUtil(Vertx vertx, InputStream inputStream) {
        this.vertx = vertx;
        this.inputStream = inputStream;
    }

    private void scheduleRead() {
        if (reading || ended) {
            return;
        }
        reading = true;

        vertx.executeBlocking(promise -> {
            try {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead == -1) {
                    promise.complete(null); // End of stream
                } else {
                    Buffer vertxBuffer = Buffer.buffer().appendBytes(buffer, 0, bytesRead);
                    promise.complete(vertxBuffer);
                }
            } catch (IOException e) {
                promise.fail(e);
            }
        }, false, result -> {
            reading = false;

            if (result.failed()) {
                if (exceptionHandler != null) {
                    exceptionHandler.handle(result.cause());
                }
                return;
            }

            Buffer data = (Buffer) result.result();
            if (data == null) {
                // End of stream
                ended = true;
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Log but don't fail
                }
                if (endHandler != null) {
                    endHandler.handle(null);
                }
            } else {
                // Data available
                if (dataHandler != null) {
                    dataHandler.handle(data);
                }
                // Schedule next read
                scheduleRead();
            }
        });
    }

    @Override
    public ReadStream<Buffer> handler(Handler<Buffer> handler) {
        this.dataHandler = handler;
        if (handler != null && !ended) {
            scheduleRead();
        }
        return this;
    }

    @Override
    public ReadStream<Buffer> pause() {
        // For simplicity, we don't implement pause/resume
        return this;
    }

    @Override
    public ReadStream<Buffer> resume() {
        return this;
    }

    @Override
    public ReadStream<Buffer> fetch(long amount) {
        return this;
    }

    @Override
    public ReadStream<Buffer> endHandler(Handler<Void> handler) {
        this.endHandler = handler;
        return this;
    }

    @Override
    public ReadStream<Buffer> exceptionHandler(Handler<Throwable> handler) {
        this.exceptionHandler = handler;
        return this;
    }
}