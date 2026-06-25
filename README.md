# 📦 comics — Hexagonal Architecture with Spring Boot

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![H2](https://img.shields.io/badge/H2-Database-blue?style=for-the-badge)

> Implementation of **Hexagonal Architecture (Ports & Adapters)** pattern using Spring Boot, MySQL and H2 for testing.

---

## 🏛️ Architecture

This project implements the **Hexagonal Architecture** (also known as Ports and Adapters pattern), which separates the core domain logic from external systems (databases, APIs, UIs).

```
src/
├── domain/           # Core business logic (entities, use cases)
│   ├── model/        # Domain entities
│   └── port/         # Interfaces (input/output ports)
├── application/      # Use cases implementation
└── infrastructure/   # Adapters (REST, DB, etc.)
    ├── rest/         # Input adapter (Controllers)
    └── persistence/  # Output adapter (JPA/MySQL)
```

**Key principles applied:**
* Domain is independent from frameworks and databases
* Business rules live in the domain layer — no Spring dependencies there
* Infrastructure adapts to the domain, not the other way around

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Primary language |
| Spring Boot | Application framework |
| Gradle | Build tool |
| MySQL | Production database |
| H2 | In-memory DB for testing |
| JUnit 5 | Unit & integration tests |

---

## 🚀 Getting Started

### Prerequisites

* Java 11+
* MySQL running locally (or use H2 for testing)
* Gradle (wrapper included)

### Clone & Run

```bash
git clone https://github.com/PedroHincapie/comics.git
cd comics
```

### Configure Database

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/comics_db
spring.datasource.username=your_user
spring.datasource.password=your_password
```

### Build & Run

```bash
./gradlew bootRun
```

### Run Tests (uses H2 in-memory)

```bash
./gradlew test
```

---

## 🧪 Testing Strategy

* **Unit tests**: Domain logic tested independently with JUnit 5
* **Integration tests**: H2 in-memory database — no external dependencies needed
* **Controller tests**: Input adapters tested with MockMvc

---

## 📐 Design Patterns Applied

* **Hexagonal Architecture** — Ports & Adapters
* **Repository Pattern** — Data access abstraction
* **Dependency Injection** — Spring IoC container
* **Command Pattern** — Use case commands

---

## 👤 Author

**Pedro Jesus Hincapié Garcia**
* LinkedIn: [pedro-jesus-hincapié-garcia](https://www.linkedin.com/in/pedro-jesus-hincapi%C3%A9-garcia/)
* GitHub: [@PedroHincapie](https://github.com/PedroHincapie)
