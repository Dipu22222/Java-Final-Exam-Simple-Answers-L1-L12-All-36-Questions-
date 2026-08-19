<%@ page import="java.sql.*" %>
<html>
<head><title>Student Records</title></head>
<body>
<h2>Student Records</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>CGPA</th></tr>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Students");

        while (rs.next()) {
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getDouble("cgpa") %></td>
</tr>
<%
        }
        con.close();
    } catch (Exception e) {
%>
<tr><td colspan="3">Error: <%= e.getMessage() %></td></tr>
<%
    }
%>
</table>
</body>
</html>
