# E-Health: Hospital Management System

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.0-brightgreen)
![License](https://img.shields.io/badge/License-MIT-yellow)

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview

E-Health is a comprehensive Hospital Management System designed to streamline various administrative and clinical operations within a hospital setting. It facilitates efficient management of patients, appointments, electronic health records (EHRs), billing, inventory, and staff roles. The system is built using Java and Spring Boot, ensuring scalability and robustness.

## Features

- **Patient Management:** Register and manage patient information, including demographics and medical history.
- **Appointment Scheduling:** Schedule, reschedule, and cancel appointments with healthcare providers.
- **Electronic Health Records (EHR):** Maintain comprehensive and secure patient medical records.
- **Billing System:** Generate and manage billing information for services rendered.
- **Inventory Management:** Track medical supplies and equipment inventory.
- **Role-Based Access Control:** Secure the system with different access levels for administrators, doctors, nurses, and other staff.

## Technologies Used

- **Backend:**
    - Java SE 17
    - Spring Boot 2.5.4
    - Spring Security for authentication and authorization
    - Hibernate ORM for database interactions
- **Database:**
    - PostgreSQL
- **Messaging:**
    - RabbitMQ for asynchronous communication
- **API Documentation:**
    - Swagger
- **Containerization:**
    - Docker

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 17:** Ensure JDK 17 is installed. [Download JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Maven:** Build tool for managing dependencies. [Download Maven](https://maven.apache.org/download.cgi)
- **Docker:** For containerization (optional). [Download Docker](https://www.docker.com/get-started)
- **PostgreSQL:** Database system. [Download PostgreSQL](https://www.postgresql.org/download/)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Aliabbos-Ashurov/e-health.git
   cd e-health
