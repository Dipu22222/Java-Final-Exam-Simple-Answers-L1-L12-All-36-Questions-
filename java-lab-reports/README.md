Java Programming Lab Reports

Course Title: Object Oriented Pattern and Design Lab Course Code: ICT 2208 Submitted By: Dipu Mondol (IT24040) Submitted To: Dr. Ziaur Rahman, Professor, Department of ICT, MBSTU

Contents
Lab	Topic
L1	Encapsulation and Polymorphism
L2	Method Overloading vs Overriding (Early vs Late Binding)
L3	Abstract Class vs Interface
L4	Collection Framework
L5	Multithreading & Custom Exception Handling
L6	JDBC with MySQL/Oracle (MVC Pattern)
L7	JavaFX — House Loan Calculator
L8	Socket Programming & Java RMI (Chat System)
L9	Servlet + JSP + JDBC CRUD (Student Records)
L10	Spring Boot REST API with JPA/ORM
L11	Servlet CRUD — District Quiz Game
L12	GoF Design Patterns
L1 — Encapsulation and Polymorphism
1.1 — What is encapsulation? (5 marks)

Encapsulation is the process of binding data (fields) and the methods that operate on that data into a single unit (class), while restricting direct access to the internal state from outside the class. In Java it is achieved by:

Declaring fields as private.
Providing controlled access through public getter and setter methods.
Optionally validating data inside setters before it is assigned.

Real-life analogy: A capsule medicine hides its internal chemical contents inside a shell — you interact with it (swallow it) without directly touching or altering its internal ingredients. Similarly, a class hides its internal data and only exposes safe, controlled methods to interact with it.

1.2 — What is polymorphism? (5 marks)

Polymorphism means "many forms" — the ability of an object or method to behave differently depending on context.

	Compile-time (Static)	Run-time (Dynamic)
Achieved by	Method Overloading	Method Overriding
Resolved at	Compile time	Run time
Example	add(int,int) vs add(double,double)	Shape reference calling overridden area() of Circle
1.3 — Practical (10 marks)

BankAccount class demonstrating encapsulation (private balance + getBalance()/deposit()) and polymorphism (overloaded deposit(double) / deposit(double, String remarks)).

java
public class BankAccount {
    private double balance; // encapsulated field

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // Overload 1
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    // Overload 2 (compile-time polymorphism)
    public void deposit(double amount, String remarks) {
        balance += amount;
        System.out.println("Deposited: " + amount + " (Remarks: " + remarks + ") | Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(0.0);
        account.deposit(5000.0);
        account.deposit(2000.0, "Salary");
        System.out.println("Final Balance: " + account.getBalance());
    }
}

Sample Output:

Deposited: 5000.0 | Balance: 5000.0
Deposited: 2000.0 (Remarks: Salary) | Balance: 7000.0
Final Balance: 7000.0
L2 — Method Overloading vs Overriding (Early vs Late Binding)
2.1 — Overloading vs Overriding (5 marks)
Aspect	Overloading	Overriding
Definition	Same method name, different parameter list, in the same class	Subclass redefines a method with the same signature as its parent
Class involved	One class	Two classes (parent–child, via inheritance)
Parameters	Must differ (number/type/order)	Must be identical
Return type	Can differ	Must be same or covariant
Binding time	Compile time (static binding)	Run time (dynamic binding)
2.2 — Early vs Late Binding (5 marks)
Early (static) binding: The compiler decides which method to call at compile time, based on the reference type. Used in overloading.
Late (dynamic) binding: The JVM decides which method to call at run time, based on the actual object type. Used in overriding, enabling polymorphism.

Overriding must be resolved at run time because the same reference type (e.g. Shape) can point to different subclass objects during execution, and the correct version can only be known once the actual object exists.

2.3 — Practical (10 marks)
java
// Shape.java
public class Shape {
    public double area() {
        return 0.0;
    }

    // Overloaded methods (early binding)
    public void describe(String name) {
        System.out.println("Describing: " + name);
    }

    public void describe(String name, int id) {
        System.out.println("Describing: " + name + " with ID " + id);
    }
}
java
// Circle.java
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
java
// Rectangle.java
public class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
java
// Main.java
public class Main {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.describe("MyShape");           // early binding
        s.describe("MyShape", 1);        // early binding

        Shape circle = new Circle(5.0);       // late binding
        Shape rectangle = new Rectangle(6.0, 4.0);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
    }
}

Sample Output:

Describing: MyShape
Describing: MyShape with ID 1
Circle Area: 78.53981633974483
Rectangle Area: 24.0
L3 — Abstract Class vs Interface
3.1 — Definitions and Differences (5 marks)

An abstract class is a class declared with the abstract keyword that cannot be instantiated and may contain both abstract (unimplemented) and concrete (implemented) methods.

An interface is a fully abstract contract (prior to Java 8) that declares method signatures which implementing classes must define; since Java 8 it can also have default and static methods.

Aspect	Abstract Class	Interface
Fields	Can have instance fields with any access modifier	Fields are implicitly public static final (constants)
Constructors	Can have constructors	Cannot have constructors
Method bodies	Can mix abstract and concrete methods	Traditionally all abstract; default/static allowed since Java 8
Multiple inheritance	A class can extend only one abstract class	A class can implement multiple interfaces
3.2 — When to Choose Which (5 marks)
Use an abstract class for an "is-a" relationship where subclasses share common state or partially implemented behavior. Example: Vehicle (abstract) → Car, Bike share fields like speed and a common startEngine() implementation.
Use an interface for a "can-do" capability that unrelated classes might share. Example: Insurable interface implemented by both Car and House, even though they don't share a common parent class.
3.3 — Practical (10 marks)
java
// Vehicle.java
public abstract class Vehicle {
    public void startEngine() {
        System.out.println("Engine started.");
    }

    public abstract String fuelType();
}
java
// Insurable.java
public interface Insurable {
    double calculatePremium();
}
java
// Car.java
public class Car extends Vehicle implements Insurable {
    private double vehicleValue;

    public Car(double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    @Override
    public String fuelType() {
        return "Petrol";
    }

    @Override
    public double calculatePremium() {
        return vehicleValue * 0.03; // 3% of vehicle value
    }
}
java
// Main.java
public class Main {
    public static void main(String[] args) {
        Car car = new Car(500000.0);
        car.startEngine();
        System.out.println("Fuel Type: " + car.fuelType());
        System.out.println("Insurance Premium: " + car.calculatePremium());
    }
}

Vehicle is abstract because all vehicles share the concrete startEngine() logic but differ in fuelType(). Insurable is an interface because "being insurable" is a capability unrelated to the vehicle hierarchy itself.

Sample Output:

Engine started.
Fuel Type: Petrol
Insurance Premium: 15000.0
L4 — Collection Framework
4.1 — ArrayList vs Vector vs LinkedList (5 marks)
Aspect	ArrayList	Vector	LinkedList
Underlying structure	Dynamic array	Dynamic array	Doubly linked list
Synchronization	Not synchronized	Synchronized (thread-safe)	Not synchronized
Random access (get)	Fast — O(1)	Fast — O(1)	Slow — O(n)
Insert/delete (middle)	Slow — requires shifting	Slow — requires shifting	Fast — O(1) once position found
4.2 — Set and Its Implementations (5 marks)

A Set is a collection that does not allow duplicate elements.

HashSet: Backed by a hash table; no guaranteed order; fastest for add/search/remove.
LinkedHashSet: Maintains insertion order using a linked list alongside the hash table.
TreeSet: Backed by a Red-Black tree (a TreeMap internally); automatically keeps elements in sorted order using natural ordering (Comparable) or a supplied Comparator.
4.3 — Practical (10 marks)
java
import java.util.ArrayList;
import java.util.TreeSet;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Rakib");
        nameList.add("Karim");
        nameList.add("Anika");
        nameList.add("Zayan");
        nameList.add("Bithi");

        System.out.print("ArrayList (insertion order): ");
        for (String name : nameList) {
            System.out.print(name + " ");
        }
        System.out.println();

        TreeSet<String> nameSet = new TreeSet<>(nameList);
        System.out.print("TreeSet (sorted order): ");
        for (String name : nameSet) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}

Sample Output:

ArrayList (insertion order): Rakib Karim Anika Zayan Bithi
TreeSet (sorted order): Anika Bithi Karim Rakib Zayan

Comment: The ArrayList preserves insertion order, while the TreeSet automatically reorders elements alphabetically, since TreeSet maintains natural (sorted) ordering rather than insertion order.

L5 — Multithreading & Custom Exception Handling
5.1 — Ways to Implement Multithreading (5 marks)
Extending the Thread class and overriding run().
Implementing the Runnable interface and passing it to a Thread object.
Using ExecutorService with Callable/Runnable for managed thread pools.

Preferred: Implementing Runnable (or using ExecutorService) is generally preferred because Java supports single inheritance — extending Thread uses the one available superclass slot, while Runnable leaves the class free to extend another class.

5.2 — Practical: Two Threads (5 marks)
java
// Thread via extending Thread class
class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Thread-A] " + i);
        }
    }
}

// Thread via implementing Runnable
class ThreadB implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Thread-B] " + i);
        }
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        Thread t2 = new Thread(new ThreadB());

        t1.start();
        t2.start();
    }
}

Sample Output (interleaving may vary):

[Thread-A] 1
[Thread-B] 1
[Thread-A] 2
[Thread-B] 2
...
5.3 — Practical: Custom Exception (10 marks)
java
class InvalidRadiusException extends Exception {
    public InvalidRadiusException(String message) {
        super(message);
    }
}

class CircleShape {
    private double radius;

    public CircleShape(double radius) throws InvalidRadiusException {
        if (radius < 0) {
            throw new InvalidRadiusException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            CircleShape invalid = new CircleShape(-2.0);
        } catch (InvalidRadiusException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            CircleShape valid = new CircleShape(5.0);
            System.out.println("Area: " + valid.area());
        } catch (InvalidRadiusException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

Sample Output:

Error: Radius cannot be negative.
Area: 78.53981633974483
L6 — JDBC with MySQL/Oracle (MVC Pattern)
6.1 — JDBC Connection Steps (5 marks)
Load the driver (auto-loaded via DriverManager in modern JDBC).
Establish a connection: Connection con = DriverManager.getConnection(url, user, password);
Create a statement: PreparedStatement for parameterized, SQL-injection-safe queries.
Execute the query: executeUpdate() for INSERT/UPDATE/DELETE, executeQuery() for SELECT.
Process results via ResultSet, then close the connection.

Key classes: DriverManager, Connection, PreparedStatement, ResultSet.

6.2 — MVC Pattern (5 marks)
Model: Represents data/state (e.g. Student class holding fields).
View: Handles user interaction/display (e.g. Main collecting input, printing output).
Controller: Contains business logic connecting Model and View (e.g. StudentDAO performing DB operations).
6.3 — Practical (10 marks)
java
// Student.java (Model)
public class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
}
java
// StudentDAO.java (Controller)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void insert(Student student) {
        String sql = "INSERT INTO students (id, name, cgpa) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getCgpa());
            ps.executeUpdate();

            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
java
// Main.java (View)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        Student student = new Student(id, name, cgpa);
        StudentDAO dao = new StudentDAO();
        dao.insert(student);

        sc.close();
    }
}

Note: Requires a running MySQL server with a students table (id INT, name VARCHAR(50), cgpa DOUBLE) and the MySQL Connector/J driver on the classpath.

L7 — JavaFX — House Loan Calculator
7.1 — JavaFX Application Structure (5 marks)
Application: The base class every JavaFX app extends; its start(Stage) method is the entry point.
Stage: The top-level window.
Scene: The container holding all visual content displayed inside a Stage.
GridPane / VBox: Layout managers that arrange child nodes in a grid or vertical stack.

Role of start(): Called automatically after launch(), where the UI is constructed and attached to the primary Stage.

7.2 & 7.3 — GridPane Layout, Formula & Event Handler (15 marks)

Amortization formula for Monthly Installment (M):

M = P × r × (1 + r)^n / ((1 + r)^n − 1)

where P = loan amount, r = monthly interest rate (annual rate / 12 / 100), n = number of months (years × 12). Total Payment = M × n; Difference = Total Payment − Loan Amount.

java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {

    private TextField loanAmountField = new TextField();
    private TextField rateField = new TextField();
    private TextField yearsField = new TextField();
    private Label monthlyLabel = new Label();
    private Label totalLabel = new Label();
    private Label diffLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Loan Amount:"), 0, 0);
        grid.add(loanAmountField, 1, 0);

        grid.add(new Label("Annual Rate (%):"), 0, 1);
        grid.add(rateField, 1, 1);

        grid.add(new Label("Number of Years:"), 0, 2);
        grid.add(yearsField, 1, 2);

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setOnAction(e -> handleCalculate());
        grid.add(calculateBtn, 1, 3);

        grid.add(new Label("Monthly Installment:"), 0, 4);
        grid.add(monthlyLabel, 1, 4);
        grid.add(new Label("Total Payment:"), 0, 5);
        grid.add(totalLabel, 1, 5);
        grid.add(new Label("Difference:"), 0, 6);
        grid.add(diffLabel, 1, 6);

        primaryStage.setScene(new Scene(grid, 350, 300));
        primaryStage.setTitle("House Loan Calculator");
        primaryStage.show();
    }

    private void handleCalculate() {
        double loanAmount = Double.parseDouble(loanAmountField.getText());
        double annualRate = Double.parseDouble(rateField.getText());
        int years = Integer.parseInt(yearsField.getText());

        double monthlyRate = annualRate / 12 / 100;
        int months = years * 12;

        double monthlyInstallment = loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)
                / (Math.pow(1 + monthlyRate, months) - 1);
        double totalPayment = monthlyInstallment * months;
        double difference = totalPayment - loanAmount;

        monthlyLabel.setText(String.format("%.2f", monthlyInstallment));
        totalLabel.setText(String.format("%.2f", totalPayment));
        diffLabel.setText(String.format("%.2f", difference));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
L8 — Socket Programming & Java RMI (Chat System)
8.1 — Socket vs RMI (5 marks)
Aspect	Socket Programming	Java RMI
Communication style	Raw byte/text streams over TCP/IP	Remote method invocation
Abstraction level	Low-level	High-level
Language dependency	Language-independent	Java-to-Java only
Use case	Simple messaging (e.g. chat)	Distributed Java applications

When to prefer: Use Sockets for lightweight cross-platform messaging like chat. Use RMI for distributed Java systems needing remote object interaction.

8.2 — Server Code (8 marks)
java
// ChatServer.java
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started, waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Client: " + message);
            out.println("Echo: " + message);
        }

        clientSocket.close();
        serverSocket.close();
    }
}
8.3 — Client Code (7 marks)
java
// ChatClient.java
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter message: ");
        String message = userInput.readLine();

        out.println(message);
        System.out.println("Server: " + in.readLine());

        socket.close();
    }
}

Sample Interaction:

Client: Hello Server
Server: Echo: Hello Server
L9 — Servlet + JSP + JDBC CRUD (Student Records)
9.1 — Project Setup Steps (5 marks)
Create a MySQL database student_db with table Students(id INT PRIMARY KEY, name VARCHAR(50), cgpa DOUBLE).
Set up a Dynamic Web Project with the MySQL Connector/J JAR in WEB-INF/lib.
Map the HTML form's action to a Servlet URL pattern via @WebServlet.
Build the JDBC connection string: jdbc:mysql://localhost:3306/student_db.
9.2 — Servlet doPost() (8 marks)
java
// StudentServlet.java
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double cgpa = Double.parseDouble(request.getParameter("cgpa"));

        String sql = "INSERT INTO Students (id, name, cgpa) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, cgpa);
            ps.executeUpdate();

            response.getWriter().println("Student added successfully.");
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
9.3 — JSP Page (7 marks)
jsp
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
L10 — Spring Boot REST API with JPA/ORM
10.1 — Setup Steps (5 marks)
Create a Spring Boot project with dependencies: spring-boot-starter-web, spring-boot-starter-data-jpa, MySQL connector.
Configure application.properties with DB URL, username, password, spring.jpa.hibernate.ddl-auto=update.
Define an @Entity class mapped to a table.
Create a JpaRepository interface for CRUD operations.
Expose endpoints via an @RestController.

Role of embedded Tomcat: Spring Boot bundles an embedded Tomcat server, so the app runs as a self-contained executable JAR without deploying to an external servlet container.

10.2 — JPA Entity + Repository (8 marks)
java
// Student.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cgpa;

    public Student() {}

    public Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public void setName(String name) { this.name = name; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
}
java
// StudentRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
10.3 — REST Controller (7 marks)
java
// StudentController.java
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
L11 — Servlet CRUD — District Quiz Game
11.1 — Database Schema Design (5 marks)

Questions Table (categories: Crops, Geography, Academic Institutions):

Column	Type
question_id	INT (PK)
category	VARCHAR(30)
question_text	VARCHAR(255)
option_a / b / c / d	VARCHAR(100)
correct_option	CHAR(1)

PlayerScore Table:

Column	Type
score_id	INT (PK, AUTO_INCREMENT)
player_name	VARCHAR(50)
final_score	INT
played_on	TIMESTAMP

Justification: Separating Questions from PlayerScore keeps quiz content independent of gameplay results, so questions can be reused across sessions and scores queried independently.

11.2 & 11.3 — Servlet Save Score + Quiz Logic (15 marks)
java
// Question.java
public class Question {
    private String category;
    private String text;
    private String optionA, optionB, optionC, optionD;
    private char correctOption;

    public Question(String category, String text, String a, String b, String c, String d, char correct) {
        this.category = category;
        this.text = text;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctOption = correct;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctOption;
    }

    public void display() {
        System.out.println("[" + category + "] " + text);
        System.out.println("A) " + optionA + "  B) " + optionB + "  C) " + optionC + "  D) " + optionD);
    }
}
java
// QuizServlet.java
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/quiz_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String playerName = request.getParameter("playerName");
        int finalScore = Integer.parseInt(request.getParameter("finalScore"));

        String sql = "INSERT INTO PlayerScore (player_name, final_score) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, playerName);
            ps.setInt(2, finalScore);
            ps.executeUpdate();

            response.getWriter().println("Score saved for " + playerName + ": " + finalScore);
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // Standalone quiz logic (can also be run outside the servlet for testing)
    public static int runQuiz() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Crops", "Which crop is Tangail region known for?",
                "Jute", "Rice", "Tea", "Cotton", 'A'));
        questions.add(new Question("Geography", "Which river flows near Tangail?",
                "Padma", "Jamuna", "Meghna", "Karnaphuli", 'B'));
        questions.add(new Question("Academic Institutions", "Which university is located in Tangail?",
                "DU", "BUET", "MBSTU", "RU", 'C'));

        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (A/B/C/D): ");
            char answer = sc.next().charAt(0);
            if (q.isCorrect(answer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }
        return score;
    }
}
L12 — GoF Design Patterns
12.1 — Creational Patterns (6 marks)
Pattern	Purpose
Singleton	Ensures a class has only one instance and provides a global access point
Factory Method	Defines an interface for creating an object, letting subclasses decide the concrete class
Abstract Factory	Produces families of related objects without specifying their concrete classes
Builder	Constructs a complex object step-by-step, separating construction from representation
Prototype	Creates new objects by cloning an existing instance
12.2 — Structural Patterns (7 marks)
Pattern	Purpose
Adapter	Converts one interface into another that a client expects
Bridge	Decouples an abstraction from its implementation so both can vary independently
Composite	Composes objects into tree structures to treat individual objects and compositions uniformly
Decorator	Adds new responsibilities to an object dynamically
Facade	Provides a simplified, unified interface to a complex subsystem
Flyweight	Shares common state across many objects to reduce memory usage
Proxy	Provides a placeholder/surrogate to control access to another object
12.3 — Practical: Singleton & Adapter (7 marks)
java
// Singleton.java (thread-safe via double-checked locking)
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // private constructor prevents external instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this.hashCode());
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.showMessage();
        s2.showMessage();
        System.out.println("Same instance? " + (s1 == s2));
    }
}
java
// Adapter.java
// Target interface expected by the client
interface MediaPlayer {
    void play(String fileName);
}

// Adaptee — incompatible interface
class AdvancedMediaPlayer {
    void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Adapter — makes AdvancedMediaPlayer usable via the MediaPlayer interface
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    @Override
    public void play(String fileName) {
        advancedPlayer.playMp4(fileName);
    }
}

public class Adapter {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("song.mp4");
    }
}

Prepared as part of the ICT 2208 course requirements, Department of ICT, MBSTU.
