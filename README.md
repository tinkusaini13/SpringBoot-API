# 📦 SpringBoot-API

A comprehensive RESTful API for managing `Customer` entities, designed with observability, containerization, and CI/CD best practices.

---

## 📌 Overview

This project showcases the complete development lifecycle of a Spring Boot-based REST API with the following key features:

- 🔧 API development with Spring Boot & Swagger
- ✅ Unit & integration testing
- 📈 Observability with Prometheus, Grafana, Loki, Tempo & OpenTelemetry
- 🐳 Docker containerization
- ☸️ Kubernetes deployment (Minikube compatible)
- 🔄 CI/CD using Jenkins
- 🖥️ CLI-based API consumer (Work in Progress)

---
📁 Project Structure (Table Format)

## 📁 Project Structure

| Path                          | Description                                      |
|-------------------------------|--------------------------------------------------|
| `SpringBoot-API/`             | Root directory                                  |
| ├── `customer/`               | Spring Boot application                         |
| │   ├── `src/`                | Java source code                                |
| │   ├── `Dockerfile`          | Dockerfile for building the app image           |
| │   └── `pom.xml`             | Maven build file                                |
| ├── `infra/`                  | Infrastructure-related files                    |
| │   └── `k8s/`                | Kubernetes manifests for deployment             |
| ├── `jenkins-pipelines/`      | Jenkins pipeline definitions                    |
| │   ├── `Jenkinsfile-App`     | Jenkinsfile for building and deploying the app  |
| │   └── `Jenkinsfile-Observability` | Jenkinsfile for deploying observability stack |
| └── `README.md`               | Project documentation                           |


---

## 🚀 Step-by-Step Implementation

### ✅ Step 1: API Development

- **Language**: Java 17
- **Framework**: Spring Boot
- **Build Tool**: Maven
- **Entity**: `Customer`
  - `id` (UUID, PK)
  - `firstName`, `middleName` (nullable), `lastName`
  - `email` (unique)
  - `phone`
- **Documentation**: Swagger UI ([http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html))
- **Database**: MySQL (Dockerized)

---

## ✨ Features

- [x] CRUD operations for Customer
- [x] Swagger/OpenAPI documentation
- [x] MySQL database integration
- [x] Docker containerization
- [x] Kubernetes-ready deployment
- [x] Jenkins CI/CD pipeline
- [x] Full observability: Logs, Metrics, Traces
- [x] CLI-based API consumer 

---

## 📖 About

> This Spring Boot-based REST API enables full CRUD functionality for managing customers. It’s equipped with a complete observability stack (Prometheus, Grafana, Loki, Tempo) and is production-ready with Docker and Kubernetes deployments. CI/CD is fully automated using Jenkins.

---

## 🛠 Tech Stack

| Category        | Tools/Technologies                    |
|-----------------|----------------------------------------|
| Backend         | Java 17, Spring Boot                  |
| API Docs        | Swagger (OpenAPI)                     |
| Database        | MySQL (Dockerized)                    |
| Containerization| Docker, Docker Compose                |
| Orchestration   | Kubernetes       |
| CI/CD           | Jenkins                               |
| Observability   | Prometheus, Grafana, Loki, Tempo      |
| Tracing         | OpenTelemetry                         |

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

Make sure the following are installed:

- Java 17+
- Maven
- Docker & Docker Compose
- Kubernetes (Minikube or Kind)
- Jenkins

📥 Clone the Repository

    git clone https://github.com/tinkusaini13/SpringBoot-API.git
    cd SpringBoot-API/jenkins-pipelines


🛢️ Database Configuration (MySQL)

| Property      | Value                             |
| ------------- | --------------------------------- |
| Host          | `mysql` (Docker/K8s service name) |
| Port          | `3306`                            |
| Database Name | `customerdb`                      |
| Username      | `root`                            |
| Password      | `root`                            |



⚠️ Note: For production, use Secrets or environment variables instead of hardcoded credentials.



📡 API Endpoints

| Method | Endpoint              | Description             |
| ------ | --------------------- | ----------------------- |
| GET    | `/api/customers`      | Retrieve all customers  |
| POST   | `/api/customers`      | Create new customer     |
| GET    | `/api/customers/{id}` | Retrieve customer by ID |
| PUT    | `/api/customers/{id}` | Update customer by ID   |
| DELETE | `/api/customers/{id}` | Delete customer by ID   |


📚 API Documentation

Swagger UI: http://localhost:8080/swagger-ui.html


📊 Observability Dashboard

| Tool       | Purpose    | Access URL                                     |
| ---------- | ---------- | ---------------------------------------------- |
| Prometheus | Metrics    | [http://localhost:9090](http://localhost:9090) |
| Grafana    | Dashboards | [http://localhost:3000](http://localhost:3000) |
| Loki       | Logs       | Accessible via Grafana                         |
| Tempo      | Traces     | Accessible via Grafana                         |


🧪 Testing

🔍 Run Unit & Integration Tests

    cd customer
    mvn clean test


📦 Containerization
Spring Boot API Service

- **Directory**: customer

- **Dockerfile Path**: customer/Dockerfile

☸️ Kubernetes Deployment

All Kubernetes manifests are located in: **infra/k8s**

- Apply resources using:

        kubectl apply -f infra/k8s/



🔁 CI/CD with Jenkins

📂 Jenkins Pipelines

| Pipeline File               | Description                                      |
| --------------------------- | ------------------------------------------------ |
| `Jenkinsfile-App`           | Build, test, dockerize, and deploy application   |
| `Jenkinsfile-Observability` | Deploy observability stack (Grafana, Prometheus) |


**-------------------------------------------------------------------------------------------------**
         ▶️  **Running the Project Steps**         
**-------------------------------------------------------------------------------------------------**



✅ Prerequisites for Jenkins Setup

Make sure your Jenkins server has:

- Jenkins (with access to Docker)
- Docker
- kubectl
- Git
- Maven

### Note:

####  Make Sure these pods are running state

- Prometheus
- Grafana
- Loki
- Tempo


