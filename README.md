# SpringBoot-API

## Overview

This project demonstrates a complete lifecycle of a RESTful API for a `Customer` entity, covering:

- Spring Boot API development with Swagger
- Integration testing
- Full observability stack with Prometheus, Grafana, Loki, Tempo, and OpenTelemetry
- Containerization with Docker
- Kubernetes deployment via Minikube
- CI/CD with Jenkins
- CLI-based API consumer

---

## 📌 Project Structure
 
---

## 🚀 Step-by-Step Implementation

### ✅ Step 1: API Development

- Technology: Java 17, Spring Boot, Maven
- Documentation: Swagger UI (http://localhost:8080/swagger-ui.html)
- Database: MySQL (containerized)
- Entity: `Customer`
  - `id` (UUID, PK)
  - `firstName` (String)
  - `middleName` (String, nullable)
  - `lastName` (String)
  - `email` (String, unique)
  - `phone` (String)




## ✨ Features

- [x] CRUD operations for Customer entity
- [x] OpenAPI (Swagger) documentation
- [x] MySQL database integration
- [x] Docker containerization
- [x] Kubernetes deployment-ready
- [x] Jenkins-based CI/CD pipeline
- [x] Observability: Logs, Metrics, Traces
- [x] CLI-based API consumer (WIP)




## 📖 About

Describe the purpose of the project, e.g.:

> This is a RESTful API built using Spring Boot that provides full CRUD operations for a `Customer` entity. It includes observability using Prometheus, Grafana, Loki, and Tempo, and is production-ready with Docker and Kubernetes deployment. CI/CD is managed with Jenkins.

---



## 🛠 Tech Stack


- Java 21, Spring Boot
- MySQL
- Docker, Docker Compose
- Kubernetes (Minikube/Kind compatible)
- Jenkins
- Prometheus + Grafana
- Loki + Tempo
- OpenTelemetry

---

## ⚙️ Setup

### ✅ Prerequisites

- Java 17+
- Maven
- Docker & Docker Compose
- Minikube or Kubernetes
- Jenkins (optional for CI/CD)



## 📊 Observability

| Tool       | Purpose     | Access URL              |
|------------|-------------|--------------------------|
| Prometheus | Metrics     | [http://localhost:9090](http://localhost:9090) |
| Grafana    | Dashboards  | [http://localhost:3000](http://localhost:3000) |
| Loki       | Logs        | Accessible via Grafana   |
| Tempo      | Traces      | Accessible via Grafana   |


## 📚 API Reference

### Swagger UI

- URL: http://localhost:8080/swagger-ui.html

- Endpoints:

## 📡 API Endpoints

| Method | Endpoint              | Description            |
|--------|------------------------|------------------------|
| GET    | `/api/customers`       | Get all customers      |
| POST   | `/api/customers`       | Create a new customer  |
| GET    | `/api/customers/{id}`  | Get customer by ID     |
| PUT    | `/api/customers/{id}`  | Update customer by ID  |
| DELETE | `/api/customers/{id}`  | Delete customer by ID  |

---

## 📊 Observability

| Tool       | Purpose     | Access URL                        |
|------------|-------------|-----------------------------------|
| Prometheus | Metrics     | [http://localhost:9090](http://localhost:9090) |
| Grafana    | Dashboards  | [http://localhost:3000](http://localhost:3000) |
| Loki       | Logs        | Accessible via Grafana            |
| Tempo      | Traces      | Accessible via Grafana            |



## 🔁 CI/CD

### Jenkins Pipelines:

- **Jenkinsfile-App**: Builds, tests, pushes Docker image, deploys to K8s
- **Jenkinsfile-Observability-Stack:** Deploys monitoring stack


✅ Testing

### Run Unit & Integration Tests

     cd customer
    ./mvnw test

## 🛢️ Database (MySQL)

| Property      | Value           |
|---------------|-----------------|
| Host          | `mysql` (from Kubernetes/Docker) |
| Port          | `3306`          |
| Database Name | `customerdb`    |
| Username      | `root`          |
| Password      | `root`          |

> ⚠️ **Note:** For production environments, avoid hardcoding credentials. Use Kubernetes Secrets, Docker Secrets, or environment variable injection securely.



## 📦 Containerization

- **Spring Boot API**
  - Located at: `customer/`
  - Dockerfile path: `customer/Dockerfile`

## ☸️ Kubernetes

- Kubernetes manifests and configurations:
  - Located in: `infra/k8s/`



# How Can Run This Project Steps:

🚀 Getting Started

✅ Prerequisites

Make sure you have the following installed and properly configured on your Jenkins server:

- Jenkins (with access to Docker socket)

- Docker

- kubectl

- Git

📥 Clone the Repository

    git clone https://github.com/tinkusaini13/SpringBoot-API.git
    cd SpringBoot-API/jenkins-pipelines


