package in.edu.kristujayanti.dbaccess;

import com.mongodb.MongoException;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.model.*;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
import in.edu.kristujayanti.exception.DataAccessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;

public abstract class MongoDataAccess {

    protected static final Logger LOGGER = LogManager.getLogger(MongoDataAccess.class);

    protected boolean saveDocument(String collectionName, Document savingDocument, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && savingDocument != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                return collection.insertOne(clientSession, savingDocument).wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while saving document {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while saving document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while save document");
        }
    }

    /**
     * Inserts the given document and returns the ObjectId of the inserted document.
     * If the document does not already have an _id, one is generated and set prior to insertion.
     *
     * @return the ObjectId that identifies the inserted document
     * @throws IllegalStateException if required parameters are missing
     * @throws DataAccessException   if a MongoDB-related error occurs or the insert is not acknowledged
     */
    protected ObjectId saveDocumentAndReturnId(String collectionName,
                                               Document savingDocument,
                                               ClientSession clientSession,
                                               MongoDatabase mongoDatabase)
            throws IllegalStateException, DataAccessException {
        if (StringUtils.isEmpty(collectionName) || savingDocument == null || clientSession == null || mongoDatabase == null) {
            throw new IllegalStateException("Invalid params found while saving document");
        }

        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);


            InsertOneResult result = collection.insertOne(clientSession, savingDocument);

            if (!result.wasAcknowledged()) {
                throw new DataAccessException("Insert operation was not acknowledged by MongoDB");
            }

            // Prefer the driver's returned id if present
            BsonValue insertedIdValue = result.getInsertedId();
            if (insertedIdValue != null && insertedIdValue.isObjectId()) {
                return insertedIdValue.asObjectId().getValue();
            }

            // Last resort: attempt to read back as ObjectId
            ObjectId docId = savingDocument.getObjectId("_id");
            if (docId != null) {
                return docId;
            }

            // If still nothing, throw – indicates an unexpected _id type scenario
            throw new DataAccessException("Inserted document _id is not an ObjectId and cannot be returned as ObjectId");
        } catch (MongoException mongoException) {
            LOGGER.error("Mongo exception occurred while saving document: {}", mongoException.getMessage(), mongoException);
            throw new DataAccessException("Mongo exception occurred while saving document: " + mongoException.getMessage());
        }
    }

    /**
     * Saves a list of documents into a specified MongoDB collection using a client session.
     *
     * @param collectionName The name of the MongoDB collection where documents will be saved.
     * @param docsList       The list of Document objects to be saved.
     * @param clientSession  The client session to use for transaction management.
     * @param mongoDatabase  The MongoDB database where the collection resides.
     * @return true if the operation was acknowledged, false otherwise.
     * @throws IllegalStateException if any required parameter is invalid or null.
     * @throws DataAccessException   if a MongoDB exception occurs during the save operation.
     */
    protected boolean saveDocuments(String collectionName, List<Document> docsList, ClientSession clientSession, MongoDatabase mongoDatabase)
            throws IllegalStateException, DataAccessException {
        // Check if all required parameters are valid
        if (!StringUtils.isEmpty(collectionName) && docsList != null && clientSession != null && mongoDatabase != null) {
            try {
                // Get the MongoDB collection
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

                // Insert the documents using the client session
                return collection.insertMany(clientSession, docsList).wasAcknowledged();
            } catch (MongoException mongoException) {
                // Catch any MongoDB exceptions
                LOGGER.error("Mongo exception occurred while saving documents: {}", mongoException.getMessage(), mongoException);
                throw new DataAccessException("Mongo exception occurred while saving documents: " + mongoException.getMessage());
            }
        } else {
            // Throw IllegalStateException if any required parameter is invalid
            throw new IllegalStateException("Invalid params found while saving documents");
        }
    }

    /**
     * @param collectionName the name of the MongoDB collection
     * @param mongoDatabase  the MongoDB database
     * @return {@link FindIterable<Document>}  containing the result set
     * @deprecated This method is deprecated. Use {@link #findDocuments(MongoDatabase, String)} or {@link #findDocuments(MongoDatabase, String, Bson, Bson)} instead.
     */
    @Deprecated(forRemoval = true)
    protected FindIterable<Document> findDocument(String collectionName, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
            return collection.find();
        } catch (MongoException mongoException) {
            LOGGER.error("Mongo exception occurred while fetching document {} ", mongoException.getMessage());
            throw new DataAccessException("Mongo exception occurred while fetching document and exception is " + mongoException.getMessage());
        }
    }

    /**
     * @param collectionName the name of the MongoDB collection
     * @param mongoDatabase  the MongoDB database
     * @param query          query to filter documents
     * @return {@link FindIterable<Document>} containing the result set
     * @deprecated This method is deprecated. Use {@link #findSingleDocument(MongoDatabase, String, Bson)} instead.
     */
    @Deprecated(forRemoval = true)
    protected Document findSingleDocument(String collectionName, Bson query, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
            FindIterable<Document> documents = collection.find(query);
            if (documents.iterator().hasNext()) {
                return documents.first();
            } else {
                return null; // Return null if no document matches the query
            }
        } catch (MongoException mongoException) {
            LOGGER.error("Mongo exception occurred while fetching document {} ", mongoException.getMessage());
            throw new DataAccessException("Mongo exception occurred while fetching document and exception is " + mongoException.getMessage());
        }
    }

    /**
     * @param collectionName the name of the MongoDB collection
     * @param mongoDatabase  the MongoDB database
     * @param query          query to filter documents
     * @return {@link FindIterable<Document>} containing the result set
     * @deprecated This method is deprecated. Use {@link #findDocumentsWithFilter(MongoDatabase, String, Bson)} or {@link #findDocuments(MongoDatabase, String, Bson, Bson)} instead.
     */
    @Deprecated(forRemoval = true)
    protected static FindIterable<Document> findAllDocumentsMatchingQuery(String collectionName, Bson query, MongoDatabase mongoDatabase) {
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
            return collection.find(query);
        } catch (Exception e) {
            System.err.println("An error occurred while querying MongoDB: " + e.getMessage());
            throw new RuntimeException("An error occurred while querying MongoDB: " + e.getMessage(), e);
        }
    }

    protected static FindIterable<Document> findAllDocumentsMatchingQuery(String collectionName, Bson query, MongoDatabase mongoDatabase, Document sortOrder) {
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
            return collection.find(query).sort(sortOrder);
        } catch (Exception e) {
            System.err.println("An error occurred while querying MongoDB: " + e.getMessage());
            throw new RuntimeException("An error occurred while querying MongoDB: " + e.getMessage(), e);
        }
    }

    protected boolean updateDocument(String collectionName, Bson filter, Document update, UpdateOptions updateOptions, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && update != null && updateOptions != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                UpdateResult result = collection.updateOne(clientSession, filter, update, updateOptions);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating document {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating document");
        }
    }

    @Deprecated(forRemoval = true)
    protected boolean updateDocument(String collectionName, Bson filter, Document update, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && update != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                UpdateOptions updateOptions = new UpdateOptions().upsert(true);
                UpdateResult result = collection.updateOne(clientSession, filter, update, updateOptions);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating document {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating document");
        }
    }

    @Deprecated(forRemoval = true)
    protected boolean updateDocuments(String collectionName, Bson filter, List<Document> updates, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && updates != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                UpdateOptions updateOptions = new UpdateOptions().upsert(true);
                UpdateResult result = collection.updateMany(clientSession, filter, updates, updateOptions);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating documents {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating documents");
        }
    }
    protected boolean updateDocuments(String collectionName, Bson filter, List<Document> updates,UpdateOptions updateOptions,ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && updates != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                UpdateResult result = collection.updateMany(clientSession, filter, updates, updateOptions);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating documents {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating documents");
        }
    }

    @Deprecated(forRemoval = true)
    protected boolean updateDocuments(String collectionName, Bson filter, Document updates, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && updates != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                UpdateOptions updateOptions = new UpdateOptions().upsert(true);
                UpdateResult result = collection.updateMany(clientSession, filter, updates, updateOptions);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating documents {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating documents");
        }
    }

    protected boolean updateDocuments(String collectionName, Bson filter, Document updates, UpdateOptions updateOptions, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && updates != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                UpdateResult result = collection.updateMany(clientSession, filter, updates, updateOptions);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating documents {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating documents");
        }
    }

    @Deprecated(forRemoval = true)
    protected Document updateAndReturnDocument(String collectionName, Bson filter, Bson update, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && update != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
                        .upsert(true)
                        .returnDocument(ReturnDocument.AFTER);

                return collection.findOneAndUpdate(clientSession, filter, update, options);
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating document: {}", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is: " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating document");
        }
    }

    @Deprecated(forRemoval = true)
    protected ObjectId updateAndReturnObjectId(
            String collectionName,
            Bson filter,
            Bson update,
            ClientSession clientSession,
            MongoDatabase mongoDatabase
    ) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && update != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
                        .upsert(true)
                        .returnDocument(ReturnDocument.AFTER);

                Document doc = collection.findOneAndUpdate(clientSession, filter, update, options);
                if (doc != null && doc.containsKey("_id")) {
                    Object idObj = doc.get("_id");
                    if (idObj instanceof ObjectId) {
                        return (ObjectId) idObj;
                    } else if (idObj != null) {
                        // If _id is not an ObjectId (e.g., String), attempt to convert
                        try {
                            return new ObjectId(idObj.toString());
                        } catch (IllegalArgumentException ex) {
                            LOGGER.error("Unable to convert _id to ObjectId: {}", idObj);
                            throw new DataAccessException("Unable to convert _id to ObjectId: " + idObj);
                        }
                    }
                }
                // No _id found or doc was null (shouldn't happen with upsert:true, but just in case)
                throw new DataAccessException("No document _id was found after update");
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while updating document: {}", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while updating document and exception is: " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while updating document");
        }
    }


    /**
     * @param collectionName  the name of the MongoDB collection
     * @param mongoDatabase   the MongoDB database
     * @param fieldsToExclude list of fields to exclude
     * @return {@link FindIterable<Document>} containing the result set
     * @deprecated This method is deprecated. Use {@link #findDocumentsWithProjection(MongoDatabase, String, Bson)} or {@link #findDocuments(MongoDatabase, String, Bson, Bson)} instead.
     */
    @Deprecated(forRemoval = true)
    protected FindIterable<Document> findDocument(String collectionName, MongoDatabase mongoDatabase, List<String> fieldsToExclude) throws IllegalStateException, DataAccessException {
        {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                return collection.find().projection(Projections.exclude(fieldsToExclude));
            } catch (MongoException var6) {
                MongoException e = var6;
                LOGGER.error("Mongo exception occurred while fetching document {} ", e.getMessage());
                throw new DataAccessException("Mongo exception occurred while fetching document and exception is " + e.getMessage());
            }
        }
    }

    protected void startTransaction(ClientSession clientSession) {
        clientSession.startTransaction(TransactionOptions.builder().writeConcern(WriteConcern.MAJORITY).build());
    }

    protected void commitTransaction(ClientSession clientSession) {
        clientSession.commitTransaction();
    }

    protected void abortTransaction(ClientSession clientSession) {
        if (clientSession.hasActiveTransaction()) {
            clientSession.abortTransaction();
        }
    }

    protected ClientSession getMongoDbSession(MongoClient mongoClient) {
        try {
            return mongoClient.startSession();
        } catch (Exception var3) {
            LOGGER.error("Session cannot be created due to {}", var3.getMessage());
            throw new IllegalStateException("Session cannot be created due to: " + var3.getMessage());
        }
    }

    protected boolean deleteDocument(String collectionName, Bson filter, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                DeleteResult result = collection.deleteOne(clientSession, filter);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while deleting document {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while deleting document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while deleting document");
        }
    }

    protected boolean deleteDocumentMany(String collectionName, Bson filter, ClientSession clientSession, MongoDatabase mongoDatabase) throws IllegalStateException, DataAccessException {
        if (!StringUtils.isEmpty(collectionName) && filter != null && clientSession != null && mongoDatabase != null) {
            try {
                MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
                DeleteResult result = collection.deleteMany(clientSession, filter);
                return result.wasAcknowledged();
            } catch (MongoException mongoException) {
                LOGGER.error("Mongo exception occurred while deleting document {} ", mongoException.getMessage());
                throw new DataAccessException("Mongo exception occurred while deleting document and exception is " + mongoException.getMessage());
            }
        } else {
            throw new IllegalStateException("Invalid params found while deleting document");
        }
    }

    /**
     * Fetches a single document from the specified MongoDB collection based on the provided filters.
     * .
     * This method retrieves a document from a MongoDB collection using the given filters.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection from which documents will be fetched.
     * @param filters        A Bson filter to specify the selection criteria for the document.
     * @return The first document from the filtered documents.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected Document findSingleDocument(MongoDatabase mongoDatabase, String collectionName, Bson filters) throws IllegalStateException, DataAccessException {
        return findDocuments(mongoDatabase, collectionName, filters, new Document()).first();
    }

    /**
     * Fetches documents from the specified MongoDB collection based on the provided filters.
     * .
     * This method retrieves documents from a MongoDB collection using the given filters.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection from which documents will be fetched.
     * @param filters        A Bson filter to specify the selection criteria for documents.
     * @return A FindIterable containing the filtered documents.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected FindIterable<Document> findDocumentsWithFilter(MongoDatabase mongoDatabase, String collectionName, Bson filters) throws IllegalStateException, DataAccessException {
        return findDocuments(mongoDatabase, collectionName, filters, new Document());
    }

    /**
     * Fetches documents from the specified MongoDB collection based on the provided projections.
     * .
     * This method retrieves documents from a MongoDB collection using the given projections.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection from which documents will be fetched.
     * @param projections    A Bson projection to specify which fields should be returned in the result.
     * @return A FindIterable containing the projected documents.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected FindIterable<Document> findDocumentsWithProjection(MongoDatabase mongoDatabase, String collectionName, Bson projections) throws IllegalStateException, DataAccessException {
        return findDocuments(mongoDatabase, collectionName, new Document(), projections);
    }

    /**
     * Fetches documents from the specified MongoDB collection.
     * .
     * This method retrieves documents from a MongoDB collection.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection from which documents will be fetched.
     * @return A FindIterable containing the documents.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected FindIterable<Document> findDocuments(MongoDatabase mongoDatabase, String collectionName) throws IllegalStateException, DataAccessException {
        return findDocuments(mongoDatabase, collectionName, new Document(), new Document());
    }

    /**
     * Fetches documents from the specified MongoDB collection based on the provided filters and projections.
     * .
     * This method retrieves documents from a MongoDB collection using the given filters and projections.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection from which documents will be fetched.
     * @param filters        A Bson filter to specify the selection criteria for documents.
     * @param projections    A Bson projection to specify which fields should be returned in the result.
     * @return A FindIterable containing the filtered and projected documents.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected FindIterable<Document> findDocuments(MongoDatabase mongoDatabase, String collectionName, Bson filters, Bson projections) throws IllegalStateException, DataAccessException {
        return findDocuments(mongoDatabase, collectionName, filters, projections, new Document());
    }

    /**
     * Fetches documents from the specified MongoDB collection based on the provided filters, projections, and sort order.
     * This method retrieves documents from a MongoDB collection using the given filters, projections, and sort order.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection from which documents will be fetched.
     * @param filters        A Bson filter to specify the selection criteria for documents.
     * @param projections    A Bson projection to specify which fields should be returned in the result.
     * @param sort           A Bson sort to specify the sort order of the result.
     * @return A FindIterable containing the filtered, projected, and sorted documents.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected FindIterable<Document> findDocuments(MongoDatabase mongoDatabase, String collectionName, Bson filters, Bson projections, Bson sort) throws IllegalStateException, DataAccessException {
        try {
            // Log the start of the operation, including the collection name
            LOGGER.debug("Attempting to fetch documents from collection: '{}' with filters: '{}' and projections: '{}'",
                    collectionName, filters.toBsonDocument(), projections.toBsonDocument());

            // Fetch the MongoDB collection
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

            // Perform the query using the provided filters and projections
            FindIterable<Document> documents = collection.find(filters).projection(projections);

            // Apply sort if not null and not empty
            if (sort != null && !sort.toBsonDocument().isEmpty()) {
                documents = documents.sort(sort);
            }

            // Log success with additional information on filters and projections
            LOGGER.debug("Successfully fetched documents from collection: '{}'. Filters: '{}', Projections: '{}'",
                    collectionName, filters.toBsonDocument(), projections.toBsonDocument());

            return documents;
        } catch (MongoException e) {
            // Log a detailed error message with the exception cause, collection name, and filters used
            LOGGER.error("Error fetching documents from collection: '{}'. Filters: '{}', Projections: '{}'. Exception: {}",
                    collectionName, filters.toBsonDocument(), projections.toBsonDocument(), e.getMessage(), e);

            // Throw a custom DataAccessException with detailed error message
            throw new DataAccessException("Error fetching documents from collection '" + collectionName +
                    "' with filters: " + filters.toBsonDocument() +
                    " and projections: " + projections.toBsonDocument() +
                    ". Exception: " + e.getMessage());
        }
    }

    /**
     * Executes an aggregation pipeline on the specified MongoDB collection.
     * This method retrieves documents from a MongoDB collection using the provided aggregation pipeline.
     * It handles any MongoDB-related exceptions and throws a custom exception for data access issues.
     *
     * @param mongoDatabase  The MongoDatabase instance to interact with.
     * @param collectionName The name of the MongoDB collection on which to run the aggregation.
     * @param pipeline       The aggregation pipeline as a list of Bson stages.
     * @return An AggregateIterable containing the aggregation results.
     * @throws IllegalStateException if the database is in an invalid state.
     * @throws DataAccessException   if a MongoDB exception occurs during the operation.
     */
    protected AggregateIterable<Document> aggregateDocuments(MongoDatabase mongoDatabase, String collectionName, List<Bson> pipeline) throws IllegalStateException, DataAccessException {
        try {
            // Log the start of the operation, including the collection name
            LOGGER.debug("Attempting to fetch documents from collection: '{}' with aggregation pipeline: '{}'",
                    collectionName, pipeline);

            // Fetch the MongoDB collection
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

            // Perform the query using the provided filters and projections
            AggregateIterable<Document> documents = collection.aggregate(pipeline);

            // Log success with additional information on filters and projections
            LOGGER.debug("Successfully fetched documents from collection: '{}'. Aggregation pipeline: '{}'",
                    collectionName, pipeline);

            return documents;
        } catch (MongoException e) {
            // Log a detailed error message with the exception cause, collection name, and filters used
            LOGGER.error("Error fetching documents from collection: '{}'. Aggregation pipeline: '{}'. Exception: {}",
                    collectionName, pipeline, e.getMessage(), e);

            // Throw a custom DataAccessException with detailed error message
            throw new DataAccessException("Error fetching documents from collection '" + collectionName +
                    "' with aggregation pipeline: " + pipeline +
                    ". Exception: " + e.getMessage());
        }
    }

    /**
     * Executes a bulk write operation on the specified MongoDB collection.
     * This method performs multiple write operations (insert, update, delete) in a single batch using the provided client session.
     *
     * @param mongoDatabase   The MongoDatabase instance to interact with.
     * @param collectionName  The name of the MongoDB collection to perform the bulk write on.
     * @param clientSession   The ClientSession to use for transaction management.
     * @param writeOperations A list of {@link WriteModel<Document>} representing the write operations to execute.
     * @return BulkWriteResult containing the result of the bulk write operation.
     * @throws IllegalStateException if any required parameter is invalid or null.
     * @throws DataAccessException   if a MongoDB exception occurs during the bulk write operation.
     */
    protected BulkWriteResult executeBulkWriteOperations(MongoDatabase mongoDatabase, String collectionName, ClientSession clientSession, List<WriteModel<Document>> writeOperations) throws IllegalStateException, DataAccessException {
        return executeBulkWriteOperations(mongoDatabase, collectionName, clientSession, writeOperations, new BulkWriteOptions().ordered(true));
    }

    /**
     * Executes a bulk write operation on the specified MongoDB collection with custom options.
     * Performs multiple write operations (insert, update, delete) in a single batch using the provided client session and bulk write options.
     *
     * @param mongoDatabase    The MongoDatabase instance to interact with.
     * @param collectionName   The name of the MongoDB collection to perform the bulk write on.
     * @param clientSession    The ClientSession to use for transaction management.
     * @param writeOperations  A list of {@link WriteModel<Document>} representing the write operations to execute.
     * @param bulkWriteOptions The {@link BulkWriteOptions} to configure the bulk write operation.
     * @return BulkWriteResult containing the result of the bulk write operation.
     * @throws IllegalStateException if any required parameter is invalid or null.
     * @throws DataAccessException   if a MongoDB exception occurs during the bulk write operation.
     */
    protected BulkWriteResult executeBulkWriteOperations(MongoDatabase mongoDatabase, String collectionName, ClientSession clientSession, List<WriteModel<Document>> writeOperations, BulkWriteOptions bulkWriteOptions) throws IllegalStateException, DataAccessException {
        try {
            // Log the start of the operation, including the collection name
            LOGGER.debug("Attempting to bulk write documents to collection: '{}'", collectionName);

            // Fetch the MongoDB collection
            MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

            return collection.bulkWrite(clientSession, writeOperations, bulkWriteOptions);
        } catch (MongoException e) {
            // Log a detailed error message
            LOGGER.error("Error bulk writing documents to collection: '{}'. Exception: {}",
                    collectionName, e.getMessage(), e);

            // Throw a custom DataAccessException with detailed error message
            throw new DataAccessException("Error bulk writing documents to collection '" + collectionName +
                    ". Exception: " + e.getMessage());
        }
    }
}