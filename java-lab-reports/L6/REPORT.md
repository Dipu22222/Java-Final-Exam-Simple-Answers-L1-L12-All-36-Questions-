# L6 — JDBC with MySQL/Oracle (MVC Pattern)

## 6.1 — JDBC Connection Steps (5 marks)

1. **Load the driver** (auto-loaded via `DriverManager` in modern JDBC/JDK 6+, driver JAR must be on classpath).
2. **Establish a connection:** `Connection con = DriverManager.getConnection(url, user, password);`
3. **Create a statement:** `PreparedStatement` for parameterized, SQL-injection-safe queries.
4. **Execute the query:** `executeUpdate()` for INSERT/UPDATE/DELETE, `executeQuery()` for SELECT (returns a `ResultSet`).
5. **Process results** via `ResultSet`, then **close** the connection.

**Key classes:** `DriverManager`, `Connection`, `PreparedStatement`, `ResultSet`.

## 6.2 — MVC Pattern (5 marks)

MVC (Model-View-Controller) separates an application into three layers:

- **Model:** Represents data/state (e.g. `Student` class holding fields).
- **View:** Handles user interaction/display (e.g. `Main` collecting input, printing output).
- **Controller:** Contains business logic connecting Model and View (e.g. `StudentDAO` performing DB operations).

This separation makes the code easier to maintain, test, and extend independently.

## 6.3 — Practical (10 marks)

See [`Student.java`](./Student.java) (Model), [`StudentDAO.java`](./StudentDAO.java) (Controller/DAO), [`Main.java`](./Main.java) (View).

**Note:** Requires a running MySQL server with a `students` table (`id INT, name VARCHAR(50), cgpa DOUBLE`) and the MySQL Connector/J driver on the classpath to actually execute against a database.
