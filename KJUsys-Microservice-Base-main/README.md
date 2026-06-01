# KJUsys Microservice Base

## Description
This is the **KJUsys Microservice Base**, a template for building Vert.x-based microservices for the Kristu Jayanti University system. It provides a standardized structure, health checks, and configuration management via Redis.

## Prerequisites
Ensure the following are installed and running:
*   **Java 17+**
*   **Redis** (for configuration)
*   **MongoDB** (database)

## Configuration
The application retrieves its configuration from a **Redis** server.

### Redis Configuration Key
*   **Key**: `app-config-values-development` (or `production`)
*   **Field**: `microservice-app-info`

### Setting up Configuration
Run the following Redis command to set the initial configuration:

```bash
hset app-config-values-development microservice-app-info '{"port":xxxx,"api_name":"KJUSYS MICROSERVICE API", "vertx_file_buffer_path": "/tmp/vertx-file-buffer", "root_directory_path": "/tmp/file-uploads"}'
```

*   `port`: The HTTP port for the service.
*   `api_name`: Descriptive name for the API (used in logs/responses).
*   `vertx_file_buffer_path`: Temp path for Vert.x file uploads.
*   `root_directory_path`: Directory to store uploaded files.

## Setup & Running

### 1. Initialize Project (First Time Only)
Run the setup script to rename the project artifacts:
```bash
./setup.sh
```

### 2. Build the Project
```bash
mvn clean package -DskipTests
```

### 3. Run the Application
Use the command below to start the service. Ensure Redis is running locally or update the address.

```bash
java -jar target/kjusys-microservice-base-1.0-SNAPSHOT-fat.jar \
  -config_server_address 127.0.0.1:6379 \
  -environment development
```

*   Replace `kjusys-microservice-base` with your new artifact ID if initialized.

## API Endpoints

### Health Check
*   **URL**: `/kjusys-api/microservice-base/health`
*   **Method**: `GET`
*   **Description**: Returns the status of the microservice.

---
**Note**: If you have run `setup.sh`, the artifact ID, config key, and context URL will be updated to reflect your project name.