package in.edu.kristujayanti.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.client.WebClient;
import io.vertx.redis.client.Redis;
import io.vertx.redis.client.RedisOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Singleton class to manage and share resources across microservices
 */
public class SharedResourceManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SharedResourceManager.class);

    private static SharedResourceManager instance;

    // Core resources
    private Vertx vertx;
    private Redis redisClient;
    private MongoClient mongoClient;
    private WebClient webClient;

    // Service-specific resources
    private final ConcurrentHashMap<String, HttpServer> httpServers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Router> routers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, MongoDatabase> mongoDatabases = new ConcurrentHashMap<>();

    // Resource usage tracking
    private final ConcurrentHashMap<String, AtomicInteger> resourceUsageCounts = new ConcurrentHashMap<>();

    // Configuration keys
    private static final String REDIS_CONNECT_INFO = "redis-connect-info";
    private static final String MONGO_CONNECT_INFO = "mongo-connect-info";
    private static final String CONNECT_URL = "connectURL";
    private static final String DB_NAME = "db_name";

    private SharedResourceManager() {
        // Private constructor to enforce singleton pattern
    }

    /**
     * Get the singleton instance of the resource manager
     *
     * @return SharedResourceManager instance
     */
    public static synchronized SharedResourceManager getInstance() {
        if (instance == null) {
            instance = new SharedResourceManager();
        }
        return instance;
    }

    /**
     * Initialize the resource manager with core shared resources
     *
     * @param config The configuration object containing connection details
     */
    public synchronized void initialize(JsonObject config) {
        if (vertx != null) {
            LOGGER.info("Resource manager already initialized");
            return;
        }

        LOGGER.info("Initializing shared resource manager");

        // Initialize Vert.x
        vertx = Vertx.vertx();
        trackResource("vertx");

        // Initialize Redis client
        if (config.containsKey(REDIS_CONNECT_INFO)) {
            initializeRedisClient(new JsonObject(config.getString(REDIS_CONNECT_INFO)));
        } else {
            LOGGER.error("Redis connection info missing from configuration");
        }

        // Initialize MongoDB client
        if (config.containsKey(MONGO_CONNECT_INFO)) {
            initializeMongoClient(new JsonObject(config.getString(MONGO_CONNECT_INFO)));
        } else {
            LOGGER.error("MongoDB connection info missing from configuration");
        }

        // Initialize web client
        webClient = WebClient.create(vertx);
        trackResource("webClient");

        LOGGER.info("Shared resource manager initialized successfully");

        // Setup shutdown hook to clean up resources
        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
    }

    /**
     * Initialize Redis client with the given configuration
     *
     * @param redisConfig Redis configuration
     */
    private void initializeRedisClient(JsonObject redisConfig) {
        if (!redisConfig.containsKey(CONNECT_URL) || redisConfig.getJsonArray(CONNECT_URL).isEmpty()) {
            LOGGER.error("Redis connect URL missing from configuration");
            return;
        }

        RedisOptions redisOptions = new RedisOptions();
        redisConfig.getJsonArray(CONNECT_URL).forEach(url -> redisOptions.addConnectionString(url.toString()));

        redisClient = Redis.createClient(vertx, redisOptions);

        redisClient.connect(res -> {
            if (res.succeeded()) {
                LOGGER.info("Shared Redis connection established");
                trackResource("redisClient");
            } else {
                LOGGER.error("Failed to establish shared Redis connection", res.cause());
            }
        });
    }

    /**
     * Initialize MongoDB client with the given configuration
     *
     * @param mongoConfig MongoDB configuration
     */
    private void initializeMongoClient(JsonObject mongoConfig) {
        if (!mongoConfig.containsKey("connection_string")) {
            LOGGER.error("MongoDB connection string missing from configuration");
            return;
        }

        try {
            String connectionString = mongoConfig.getString("connection_string");
            // Add database name to connection string if provided separately
            if (mongoConfig.containsKey(DB_NAME) && !connectionString.contains("/")) {
                connectionString += "/" + mongoConfig.getString(DB_NAME);
            }

            // Using MongoClients factory method from the synchronous driver
            mongoClient = MongoClients.create(connectionString);
            LOGGER.info("Shared MongoDB connection established");
            trackResource("mongoClient");

            // Initialize default database if specified
            if (mongoConfig.containsKey(DB_NAME)) {
                String defaultDbName = mongoConfig.getString(DB_NAME);
                getMongoDatabase(defaultDbName);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to establish shared MongoDB connection", e);
        }
    }

    /**
     * Get Vert.x instance
     *
     * @return Shared Vert.x instance
     */
    public Vertx getVertx() {
        return vertx;
    }

    /**
     * Get Redis client
     *
     * @return Shared Redis client
     */
    public Redis getRedisClient() {
        return redisClient;
    }

    /**
     * Get MongoDB client
     *
     * @return Shared MongoDB client
     */
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    /**
     * Get WebClient instance
     *
     * @return Shared WebClient instance
     */
    public WebClient getWebClient() {
        return webClient;
    }

    /**
     * Get or create a service-specific HTTP server
     *
     * @param serviceName Name of the service to identify the server
     * @return HTTP server instance
     */
    public HttpServer getHttpServer(String serviceName) {
        return httpServers.computeIfAbsent(serviceName, k -> {
            HttpServer server = vertx.createHttpServer();
            trackResource("httpServer:" + serviceName);
            return server;
        });
    }

    /**
     * Get or create a service-specific router
     *
     * @param serviceName Name of the service to identify the router
     * @return Router instance
     */
    public Router getRouter(String serviceName) {
        return routers.computeIfAbsent(serviceName, k -> {
            Router router = Router.router(vertx);
            trackResource("router:" + serviceName);
            return router;
        });
    }

    /**
     * Get or create a MongoDB database connection
     *
     * @param dbName Name of the database
     * @return MongoDB database instance
     */
    public MongoDatabase getMongoDatabase(String dbName) {
        return mongoDatabases.computeIfAbsent(dbName, k -> {
            MongoDatabase db = mongoClient.getDatabase(dbName);
            trackResource("mongoDatabase:" + dbName);
            return db;
        });
    }

    /**
     * Track resource usage
     *
     * @param resourceName Name of the resource to track
     */
    private void trackResource(String resourceName) {
        resourceUsageCounts.computeIfAbsent(resourceName, k -> new AtomicInteger(0))
                .incrementAndGet();
    }

    /**
     * Get current memory usage information
     *
     * @return JsonObject with memory usage information
     */
    public JsonObject getMemoryUsageInfo() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory() / (1024 * 1024);

        JsonObject memoryInfo = new JsonObject()
                .put("totalMemoryMB", totalMemory)
                .put("usedMemoryMB", usedMemory)
                .put("freeMemoryMB", freeMemory)
                .put("maxMemoryMB", maxMemory)
                .put("usagePercentage", (int)(usedMemory * 100 / maxMemory));

        JsonObject resourceCounts = new JsonObject();
        resourceUsageCounts.forEach((resource, count) ->
                resourceCounts.put(resource, count.get()));

        return new JsonObject()
                .put("memoryInfo", memoryInfo)
                .put("resourceCounts", resourceCounts);
    }

    /**
     * Shutdown and clean up all resources
     */
    public void shutdown() {
        LOGGER.info("Shutting down shared resource manager");

        // Close HTTP servers
        httpServers.forEach((name, server) -> {
            try {
                server.close();
                LOGGER.info("HTTP server closed: {}", name);
            } catch (Exception e) {
                LOGGER.error("Error closing HTTP server: {}", name, e);
            }
        });

        // Close Redis client
        if (redisClient != null) {
            try {
                redisClient.close();
                LOGGER.info("Redis client closed");
            } catch (Exception e) {
                LOGGER.error("Error closing Redis client", e);
            }
        }

        // Close MongoDB client
        if (mongoClient != null) {
            try {
                mongoClient.close();
                LOGGER.info("MongoDB client closed");
            } catch (Exception e) {
                LOGGER.error("Error closing MongoDB client", e);
            }
        }

        // Close Vert.x
        if (vertx != null) {
            try {
                vertx.close();
                LOGGER.info("Vert.x closed");
            } catch (Exception e) {
                LOGGER.error("Error closing Vert.x", e);
            }
        }

        LOGGER.info("All shared resources have been closed");
    }
}