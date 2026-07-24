# 🏥 Hospital Management System

A **Hospital and Appointment Management System** backend project built with Java Spring Boot, following Layered Architecture and RESTful API standards.

---

## 🚀 About the Project

This system enables the integrated management of hospitals, departments, doctors, and patients, allowing patients to schedule appointments based on specific medical specializations and hospitals.

### 🔑 Key Features
* **Hospital Management:** Register new hospitals and list existing ones.
* **Department & Specialization Management:** Define departments within hospitals and pair them with enum-based medical specializations (`Specialization`).
* **Doctor Management:** Register doctors associated with their respective specializations, departments, and hospitals.
* **Patient Management:** Register patients with national identity numbers (TCKN) and contact details.
* **Flexible Appointment System:** Enable patients to schedule appointments with doctors based on hospital and specialization preferences without conflicting schedules.

---

## 🛠️ Tech Stack & Tools

* **Java 17+**
* **Spring Boot 3.x**
  * Spring Data JPA (Database operations)
  * Spring Web (RESTful API)
  * Spring Validation (Input validation)
* **PostgreSQL / H2** (Database)
* **MapStruct** (Entity - DTO mapping)
* **Lombok** (Boilerplate code reduction)
* **Swagger / OpenAPI** (API Documentation)
* **Maven** (Dependency Management)
