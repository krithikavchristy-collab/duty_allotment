package in.edu.kristujayanti.util.export;

import com.opencsv.CSVWriter;
import in.edu.kristujayanti.propertyBinder.PropertyBinderUtils;
import org.bson.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Utility class for creating and managing CSV output.
 * Supports instance-based CSV streaming, and static one-shot exports, including from BSON Document lists.
 */
public class CsvExporter {
    private final CSVWriter csvWriter;
    private final Writer writer;
    private final ByteArrayOutputStream outputStream;

    /**
     * Creates a CsvExporter that writes to an internal ByteArrayOutputStream.
     */
    public CsvExporter() {
        this.outputStream = new ByteArrayOutputStream();
        this.writer = new OutputStreamWriter(this.outputStream, StandardCharsets.UTF_8);
        this.csvWriter = new CSVWriter(this.writer);
    }

    /**
     * Creates a CsvExporter that writes to a provided Writer.
     * OutputStream will be null in this case.
     *
     * @param writer Writer to write CSV to.
     */
    public CsvExporter(Writer writer) {
        this.writer = writer;
        this.csvWriter = new CSVWriter(writer);
        this.outputStream = null;
    }

    /**
     * Write a header row.
     */
    public void writeHeader(List<String> headers) {
        csvWriter.writeNext(headers.toArray(new String[0]));
    }

    /**
     * Write a data row.
     */
    public void writeRow(List<String> row) {
        csvWriter.writeNext(row.toArray(new String[0]));
    }

    /**
     * Write multiple rows.
     */
    public void writeRows(List<List<String>> rows) {
        for (List<String> row : rows) writeRow(row);
    }

    /**
     * Flush the underlying writer.
     */
    public void flush() throws IOException {
        csvWriter.flush();
        writer.flush();
    }

    /**
     * Close everything.
     */
    public void close() throws IOException {
        csvWriter.close();
        writer.close();
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /**
     * If using internal ByteArrayOutputStream, get result as byte[].
     */
    public byte[] toByteArray() throws IOException {
        flush();
        if (outputStream == null)
            throw new IllegalStateException("No internal output stream. Use the writer you provided.");
        return outputStream.toByteArray();
    }

    /**
     * If using internal ByteArrayOutputStream, get result as String.
     */
    public String toStringResult() throws IOException {
        return new String(toByteArray(), StandardCharsets.UTF_8);
    }

    /**
     * Create CSV from {@code List<Document>}, filter out "_File" and "_id", map headers with PropertyBinderUtils, return as bytes.
     *
     * @param documents List of BSON Documents
     * @return CSV as bytes
     */
    public static byte[] createCsvBytesFromDocuments(List<Document> documents) throws IOException {
        if (documents == null || documents.isEmpty()) return new byte[0];

        // 1. Collect union of all keys (preserve first-seen order)
        Set<String> rawHeaders = new LinkedHashSet<>();
        for (Document doc : documents) {
            rawHeaders.addAll(doc.keySet());
        }
        // 2. Exclude unwanted fields
        List<String> filteredHeaders = rawHeaders.stream()
                .filter(header -> !header.contains("_File") && !"_id".equals(header))
                .toList();

        // 3. Map to display names (fallback to property name)
        List<String> displayHeaders = filteredHeaders.stream()
                .map(header -> {
                    try {
                        String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(header);
                        return displayName != null ? displayName : header;
                    } catch (Exception e) {
                        return header;
                    }
                })
                .toList();

        // 4. Prepare rows (use the full header set, default to "" for missing keys)
        List<List<String>> rows = documents.stream()
                .map(doc -> filteredHeaders.stream()
                        .map(key -> doc.getOrDefault(key, "").toString())
                        .toList())
                .toList();

        return createCsvBytes(displayHeaders, rows);
    }

    /**
     * Static utility variant for direct one-shot CSV creation.
     */
    public static byte[] createCsvBytes(List<String> headers, List<List<String>> rows) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);
             CSVWriter csvWriter = new CSVWriter(outputStreamWriter)) {

            csvWriter.writeNext(headers.toArray(new String[0]));
            for (List<String> row : rows) {
                csvWriter.writeNext(row.toArray(new String[0]));
            }
            csvWriter.flush();
            return byteArrayOutputStream.toByteArray();
        }
    }

    /**
     * Static utility: create CSV and write to output stream directly.
     */
    public static void writeCsv(OutputStream out, List<String> headers, List<List<String>> rows) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
             CSVWriter csvWriter = new CSVWriter(writer)) {
            csvWriter.writeNext(headers.toArray(new String[0]));
            for (List<String> row : rows) {
                csvWriter.writeNext(row.toArray(new String[0]));
            }
            csvWriter.flush();
        }
    }
}