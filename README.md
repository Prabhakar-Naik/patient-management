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
