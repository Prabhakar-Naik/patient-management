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
cd patient-management-microservice

```

