# 🌐 Job Management System – Microservices Architecture

## 🧭 Overview
The **Job Management System** is a scalable and distributed application built using **Spring Boot Microservices**.  
This project demonstrates the transition from a **monolithic architecture** to a **decoupled microservices-based system**, focusing on scalability, maintainability, and observability.

The system manages job postings, company data, and user reviews through independent services that collaborate to provide a unified response.

This project was built as part of a practical learning journey to strengthen backend development, microservices architecture, and DevOps skills.

---

## 🏗️ System Architecture
The system consists of three core microservices that communicate synchronously:

- **Company Microservice (8081)**  
  Manages company profiles and organizational data.

- **Job Microservice (8082)**  
  Handles job postings, salary ranges, and job locations.

- **Review Microservice (8083)**  
  Manages user feedback and company ratings.

Each microservice is independently deployable and owns its own database.

---

## 🛠️ Tools & Technologies

| Category | Tool / Technology | Purpose |
|--------|------------------|---------|
| Backend Framework | Spring Boot | Building microservices |
| Service Discovery | Netflix Eureka | Service registry and discovery |
| Inter-Service Communication | RestTemplate + DTO Pattern | Synchronous communication |
| Distributed Tracing | Micrometer & Zipkin | Request flow tracking |
| Database | PostgreSQL | Persistent data storage |
| Containerization | Docker & Docker Compose | Application deployment |
| Monitoring | Spring Boot Actuator | Health checks and metrics |
| Version Control | Git & GitHub | Source code management |

---

## 🧰 Core Microservices and Responsibilities

| Microservice | Description |
|-------------|------------|
| Company Service | Manages company information |
| Job Service | Manages job postings |
| Review Service | Manages reviews and ratings |

---

## 🔄 Inter-Service Communication
- Services communicate synchronously using **RestTemplate**.
- **DTO Pattern** is used to decouple service contracts.
- Job Service aggregates data from Company and Review services to return a unified response.

---

## 🧵 Distributed Tracing & Monitoring
- Integrated **Micrometer** and **Zipkin** for tracing.
- Tracks requests across multiple services.
- Helps identify latency issues and communication bottlenecks.

---

## 🐳 Docker Configuration
The system is fully containerized using Docker and managed via Docker Compose.
All services run inside a dedicated Docker network.


---




