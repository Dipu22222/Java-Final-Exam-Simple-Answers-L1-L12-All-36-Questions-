# L9 — Servlet + JSP + JDBC CRUD (Student Records)

## 9.1 — Project Setup Steps (5 marks)

1. Create a MySQL database `student_db` with a table `Students(id INT PRIMARY KEY, name VARCHAR(50), cgpa DOUBLE)`.
2. Set up a Dynamic Web Project (e.g. in Eclipse/NetBeans) with the MySQL Connector/J JAR added to `WEB-INF/lib`.
3. Map the HTML form's `action` to a Servlet URL pattern defined via `@WebServlet` annotation or `web.xml`.
4. Build the JDBC connection string: `jdbc:mysql://localhost:3306/student_db`.

## 9.2 — Servlet doPost() (8 marks)

See [`StudentServlet.java`](./StudentServlet.java). Reads `id`, `name`, `cgpa` from the submitted form and inserts them using a `PreparedStatement`, wrapped in try-catch for `SQLException`.

## 9.3 — JSP Page (7 marks)

See [`students.jsp`](./students.jsp). Connects to `student_db`, runs `SELECT * FROM Students`, and renders the results as an HTML table.
