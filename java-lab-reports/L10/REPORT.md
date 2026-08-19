# L10 — Spring Boot REST API with JPA/ORM

## 10.1 — Setup Steps (5 marks)

1. Create a Spring Boot project (via Spring Initializr) with dependencies: `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, and the MySQL connector.
2. Configure `application.properties` with the database URL, username, password, and `spring.jpa.hibernate.ddl-auto=update`.
3. Define an `@Entity` class mapped to a table.
4. Create a `JpaRepository` interface for CRUD operations.
5. Expose endpoints via an `@RestController`.

**Role of embedded Tomcat:** Spring Boot bundles an embedded Tomcat server, so the application runs as a self-contained executable JAR without needing to deploy to an external servlet container.

## 10.2 — JPA Entity + Repository (8 marks)

See [`Student.java`](./Student.java) and [`StudentRepository.java`](./StudentRepository.java).

## 10.3 — REST Controller (7 marks)

See [`StudentController.java`](./StudentController.java) — exposes `GET /students` and `POST /students`.
