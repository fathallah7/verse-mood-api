# VerseMood 

> AI-powered Quran API that recommends verses based on your mood and emotional state.

[![Java](https://img.shields.io/badge/Java-25-orange?style=flat-square)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL--blue?style=flat-square)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)](LICENSE)

---

## Overview

VerseMood is a RESTful API built with Spring Boot that allows users to:

- Browse Quran surahs and ayahs in Arabic
- View tafsir (interpretation) for each verse
- Get AI-based verse recommendations based on their emotional state

---

## Features

| Feature | Description |
|---|---|
| Quran Reader | Browse all 114 surahs and 6,236 ayahs |
| Tafsir | Al-Muyassar interpretation bundled with every ayah |
| AI Recommendation | Get ayahs that match your current mood *(coming soon)* |

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 3 |
| Database | MySQL 8 |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |

---

## 🗂 Project Structure

```
src/
└── main/
    └── java/
        └── com/versemood/
            ├── controller/        ← HTTP layer
            ├── dto/
            │   ├── ApiResponse.java
            │   ├── request/       ← Incoming requests
            │   └── response/      ← Outgoing responses
            ├── entity/            ← JPA entities
            ├── exception/         ← Custom exceptions & handler
            ├── repository/        ← Spring Data repositories
            ├── service/           ← Business logic
            └── VerseMoodApplication.java
```

---

## Getting Started


### Installation

**1. Clone the repository**

```bash
git clone https://github.com/yourusername/versemood.git
cd versemood
```

**2. Create the database**

```sql
CREATE DATABASE versemood CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

**3. Import the Quran data**

```bash
mysql -u your_username -p versemood < quran_text.sql
mysql -u your_username -p versemood < ar_muyassar.sql
```

**4. Configure `application.properties`**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/versemood
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**5. Run the application**

```bash
mvn spring-boot:run
```

API will be available at `http://localhost:8080`

---

## API Reference

### Base URL

```
http://localhost:8080/api/v1
```

### Response Format

All endpoints return a unified response wrapper:

```json
{
  "success": true,
  "message": "Ayahs retrieved successfully",
  "data": { }
}
```

### Error Format

```json
{
  "success": false,
  "message": "Ayah not found — Surah 1, Ayah 99"
}
```

---

### Endpoints

#### Get all ayahs in a surah

```http
GET /api/v1/surahs/{surahNumber}/ayahs
```

| Parameter | Type | Description |
|---|---|---|
| `surahNumber` | `Integer` | Surah number (1–114) |

**Example Request:**
```bash
curl http://localhost:8080/api/v1/surahs/1/ayahs
```

**Example Response:**
```json
{
  "success": true,
  "message": "Ayahs retrieved successfully",
  "data": [
    {
      "id": 1,
      "surahNumber": 1,
      "ayahNumber": 1,
      "arabicText": "      ",
      "tafsirText": "      "
    }
  ]
}
```

---

#### Get a single ayah

```http
GET /api/v1/surahs/{surahNumber}/ayahs/{ayahNumber}
```

| Parameter | Type | Description |
|---|---|---|
| `surahNumber` | `Integer` | Surah number (1–114) |
| `ayahNumber` | `Integer` | Ayah number |

**Example Request:**
```bash
curl http://localhost:8080/api/v1/surahs/2/ayahs/255
```

**Example Response:**
```json
{
  "success": true,
  "message": "Ayah retrieved successfully",
  "data": {
    "id": 262,
    "surahNumber": 2,
    "ayahNumber": 255,
    "arabicText": "   ",
    "tafsirText": "   "
  }
}
```

---

#### Recommend ayahs by mood *(coming soon)*

```http
POST /api/v1/recommend
```

**Request Body:**
```json
{
  "mood": " "
}
```

**Response:**
```json
{
  "success": true,
  "message": "Recommendations retrieved successfully",
  "data": []
}
```

---


## 🗄 Database Schema

```sql
-- Quran Text
CREATE TABLE quran_text (
  `index` INT PRIMARY KEY AUTO_INCREMENT,
  sura    INT NOT NULL,
  aya     INT NOT NULL,
  text    TEXT NOT NULL
);

-- Tafsir Al-Muyassar
CREATE TABLE ar_muyassar (
  `index` INT PRIMARY KEY AUTO_INCREMENT,
  sura    INT NOT NULL,
  aya     INT NOT NULL,
  text    TEXT NOT NULL
);
```

