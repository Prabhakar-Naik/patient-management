### License
<h5>Copyright © 2025 Code Prabhakar | Original Course Material by @Prabhakar-Naik</h5>
# patient-management microservice

This project implements a Patient Management system using a microservices architecture. It's designed to be modular, scalable, and resilient, leveraging various technologies like Spring Boot, Kafka, gRPC, and Docker.

## Table of Contents
* [Overview](#overview)
* [Features](#features)
* [Architecture](#architecture)
* [Services](#services)
* [Technologies Used](#technologies-used)
* [Prerequisites](#prerequisites)
* [Getting Started](#getting-started)
    * [Cloning the Repository](#cloning-the-repository)
    * [Setting up Docker](#setting-up-docker)
    * [Building and Running the Services](#building-and-running-the-services)
* [API Documentation](#api-documentation)
* [Testing](#testing)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)

## Overview
The Patient Management Microservice project provides a comprehensive solution for managing patient data and related healthcare workflows. It is built using a microservices architecture to ensure maintainability, scalability, and independent deployment of individual services.  The system handles patient registration, data management, billing, analytics, and integrates with other potential healthcare services.

## Features

* **Patient Management:** Create, read, update, and delete patient records.
* **Billing:** Generate and manage patient bills.
* **Authentication and Authorization:** Secure access to services with user authentication and authorization.
* **Analytics:** Gather and analyze patient data for reporting and insights.
* **API Gateway:** A single entry point for accessing different services.
* **Asynchronous Communication:** Uses Kafka for message-based communication between services.
* **Inter-service Communication:** Implements gRPC for efficient communication between services.
* **Database Management:** Utilizes PostgreSQL for persistent data storage.
* **Containerization:** Uses Docker for easy setup and deployment.
* **Comprehensive Testing**: Includes Integration Tests for system reliability

## Architecture
The project follows a microservices architecture, where each service is responsible for a specific business function.

Here's a high-level overview:

* **api-gateway:** Handles external requests and routes them to the appropriate backend services.
* **patient-service:** Manages patient-related data.
* **billing-service:** Handles billing and payment processing.
* **auth-service:** Provides authentication and authorization for users.
* **analytics-service**: Provides analytical data.
* **kafka-service:** Handles asynchronous messaging using Kafka.
* **grpc-requests & api-requests:** Defines the structure of the gRPC and REST API requests.
* **infrastructure:** Contains infrastructure-related configurations (e.g., Dockerfiles, network setup).
* **integration-tests:** Contains integration tests to validate the interaction between microservices.
* **postgresql:** The PostgreSQL database.

## Services
Here's a breakdown of the key services:
* **analytics-service:** This service is responsible for collecting and analyzing patient data. It likely provides insights into patient demographics, trends, and other relevant metrics.
* **api-gateway:** This service acts as the entry point for all external requests.  It routes requests to the appropriate backend services (e.g., patient-service, billing-service).  It may also handle authentication, authorization, and other cross-cutting concerns.
* **api-requests:** This likely contains the definitions or models for the request and response payloads used by the REST APIs exposed by the services.  This promotes code sharing and consistency.
* **auth-service:** This service handles user authentication (verifying identity) and authorization (determining access rights).  It ensures that only authorized users can access specific resources.
* **billing-service:** This service manages all aspects of patient billing, including generating invoices, processing payments, and tracking billing history.
* **grpc-requests:** Similar to `api-requests`, this likely contains the protocol buffer definitions (`.proto` files) for the gRPC APIs used for communication between services.  gRPC is often used for high-performance, efficient communication.
* **infrastructure:** This directory/service contains the necessary infrastructure-as-code (IaC) configurations.  For example, Dockerfiles for building the service containers, Docker Compose files for orchestrating the services, and potentially network configurations.
* **integration-tests:** This is a crucial part of the project, containing tests that verify the correct interaction between different microservices.  Integration tests ensure that the system works as a whole, not just individual services in isolation.
* **patient-service:** This is the core service for managing patient data.  It handles creating, retrieving, updating, and deleting patient records.
* **kafka-service:** This service enables asynchronous communication between microservices.  Instead of direct, synchronous calls, services can exchange messages via Kafka, improving performance, reliability, and decoupling.
* **postgresql:** This represents the PostgreSQL database instance used by the microservices for persistent storage of data.  In a Dockerized environment, this would be a PostgreSQL container.

## Technologies Used
* Java/Spring Boot:  Backend services
* Kafka: Asynchronous messaging
* gRPC: Inter-service communication
* PostgreSQL: Database
* Docker: Containerization

## Prerequisites
* Java Development Kit (JDK) 17 or higher
* Docker
* Git

## Getting Started

Follow these steps to get the project up and running:

### Cloning the Repository

```bash
git clone https://github.com/Prabhakar-Naik/patient-management.git
cd patient-management

```
### Setting up Docker
Ensure Docker is installed and running on your system.  You can download it from <a href="https://www.docker.com/">get-started.</a>

### Building and Running the Services
Navigate to the project root directory.
<h1>Build the Docker images:</h1>
<h2>PostgreSql databases for patient-service and auth-service</h2>
Below details setup manually. everything comes under modify options in intellij

# patient-service-db

```
Name: patient-service-db
Server: Docker
Image ID or name: postgres:latest
Container Name: patient-service-db
Bind Ports: 5000:5432
Bind Mounts: Host Path: C:\Users\prabh\db_volumes\patient-service-db, Container Path: /var/lib/postgresql/data
Run options: --network internal

```
<h3>Environment Variables:</h3>

```
POSTGRES_DB=db;
POSTGRES_PASSWORD=password;
POSTGRES_USER=admin_user
```
# auth-service-db

```
Name: auth-service-db
Server: Docker
Image ID or name: postgres:latest
Container Name: auth-service-db
Bind Ports: 5001:5432
Bind Mounts: Host Path: C:\Users\prabh\db_volumes\auth-service-db, Container Path: /var/lib/postgresql/data
Run options: --network internal
```
<h3>Environment Variables:</h3>

```
POSTGRES_DB=db;
POSTGRES_PASSWORD=password;
POSTGRES_USER=admin_user
```
# patient-service

```
Name: patient-service
Server: Docker
Dockerfile: patient-service\Dockerfile
Image ID or name: patient-service:latest
Container Name: patient-service
Bind Ports: 8090:8090   -- temporarly
Run options: --network internal
```
<h3>Environment Variables:</h3>

```
BILLING_SERVICE_ADDRESS=billing-service;
BILLING_SERVICE_GRPC_PORT=8092;
SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver;
SPRING_DATASOURCE_PASSWORD=password;
SPRING_DATASOURCE_URL=jdbc:postgresql://patient-service-db:5432/db;
SPRING_DATASOURCE_USERNAME=admin_user;
SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect;
SPRING_JPA_HIBERNATE_DDL_AUTO=update;
SPRING_JPA_SHOW_SQL=true;
SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9082;
SPRING_SQL_INIT_MODE=always
```
# auth-service

```
Name: auth-service
Server: Docker
Dockerfile: auth-service\Dockerfile
Image ID or name: auth-service:latest
Container Name: auth-service
Bind Ports: 4005:4005   -- temporarly
Run options: --network internal
```
<h3>Environment Variables:</h3>

```
JWT_SECRET=a05b31d48763abc6254ee6c5dc77d67266a0a7da1114f5763d0abf07bd66c724;
SPRING_DATASOURCE_PASSWORD=password;
SPRING_DATASOURCE_URL=jdbc:postgresql://auth-service-db:5432/db;
SPRING_DATASOURCE_USERNAME=admin_user;
SPRING_JPA_HIBERNATE_DDL_AUTO=update;
SPRING_SQL_INIT_MODE=always
```
# kafka
```
Name: kafka
Server: Docker
Image ID or name: bitnami/kafka:latest
Container Name: kafka
Bind Ports: 9082:9082 9084:9084
Run options: --network internal
```
<h3>Environment Variables:</h3>

```
KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9082,EXTERNAL://localhost:9084;
KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER;
KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@kafka:9083;
KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT,PLAINTEXT:PLAINTEXT;
KAFKA_CFG_LISTENERS=PLAINTEXT://:9082,CONTROLLER://:9083,EXTERNAL://:9084;
KAFKA_CFG_NODE_ID=0;KAFKA_CFG_PROCESS_ROLES=controller,broker
```
# billing-service
```
Name: billing-service
Server: Docker
Dockerfile: billing-service\Dockerfile
Image ID or name: billing-service:latest
Container Name: billing-service
Bind Ports: 8091:8091 8092:8092
Run options: --network internal
```
# analytics-service
```
Name: analytics-service
Server: Docker
Dockerfile: analytics-service\Dockerfile
Image ID or name: analytics-service:latest
Container Name: analytics-service
Bind Ports: 8093:8093
Run options: --network internal
```
<h3>Environment Variables:</h3>

```
SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9082
```
# api-gateway
```
Name: api-gateway
Server: Docker
Dockerfile: api-gateway\Dockerfile
Image ID or name: api-gateway:latest
Container Name: api-gateway
Bind Ports: 4004:4004
Run options: --network internal
```
<h3>Environment Variables:</h3>

```
AUTH_SERVICE_URL=http://auth-service:4005
```
### API Documentation
```
patient-service: GET http://localhost:4004/api-docs/patients
auth-service: GET http://localhost:4004/api-docs/auth
```
### Testing
The project includes integration tests to ensure the correct interaction between microservices.

### Contributing
We welcome contributions to the Patient Management Microservice project!  Please follow these steps:
Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and commit them with descriptive commit messages.
Push your changes to your fork.
Submit a pull request to the main branch of the original repository.

### Contact
* 🖥️  See my portfolio at [Prabhakak portfolio](http://prabhakar-profile.vercel.app/)
* ✉️  You can contact me at [prabhakarnaik225@gmail.com](mailto:prabhakarnaik225@gmail.com)
