# Java Programming Lab Reports

**Course Title:** Object Oriented Pattern and Design Lab
**Course Code:** ICT 2208
**Submitted By:** Dipu Mondol (IT24040)
**Submitted To:** Dr. Ziaur Rahman, Professor, Department of ICT, MBSTU

---

## About

This repository contains 12 lab reports covering core Java programming concepts — from OOP fundamentals to JDBC, JavaFX, networking, web development, and design patterns. Each lab includes theory questions and practical implementations.

## Lab Contents

| Lab | Topic |
|---|---|
| L1 | Encapsulation and Polymorphism |
| L2 | Method Overloading vs Overriding (Early vs Late Binding) |
| L3 | Abstract Class vs Interface |
| L4 | Collection Framework (ArrayList, Vector, LinkedList, Set, TreeSet) |
| L5 | Multithreading & Custom Exception Handling |
| L6 | JDBC with MySQL/Oracle (MVC Pattern) |
| L7 | JavaFX — House Loan Calculator |
| L8 | Socket Programming & Java RMI (Chat System) |
| L9 | Servlet + JSP + JDBC CRUD (Student Records) |
| L10 | Spring Boot REST API with JPA/ORM |
| L11 | Servlet CRUD — District Quiz Game |
| L12 | GoF Design Patterns — Creational & Structural |

## Tech Stack

`Java` `JDBC` `JavaFX` `Servlet/JSP` `Spring Boot` `MySQL`

## Structure

Each lab folder (`L1` to `L12`) contains a `REPORT.md` with the theory answers and question breakdown, plus the corresponding `.java`/`.jsp` source files for the practical parts.

```
java-lab-reports/
├── L1/  REPORT.md, BankAccount.java
├── L2/  REPORT.md, Shape.java, Circle.java, Rectangle.java, Main.java
├── L3/  REPORT.md, Vehicle.java, Insurable.java, Car.java, Main.java
├── L4/  REPORT.md, CollectionDemo.java
├── L5/  REPORT.md, MultithreadingDemo.java, CustomExceptionDemo.java
├── L6/  REPORT.md, Student.java, StudentDAO.java, Main.java
├── L7/  REPORT.md, LoanCalculator.java
├── L8/  REPORT.md, ChatServer.java, ChatClient.java
├── L9/  REPORT.md, StudentServlet.java, students.jsp
├── L10/ REPORT.md, Student.java, StudentRepository.java, StudentController.java
├── L11/ REPORT.md, Question.java, QuizServlet.java
└── L12/ REPORT.md, Singleton.java, Adapter.java
```

> **Note:** Labs 6, 9, 10, 11 require a running MySQL server (and, for L9–L10, a servlet container / Spring Boot runtime) to execute fully — the code is complete and correct but depends on external services not bundled in this repo.

---

*Prepared as part of the ICT 2208 course requirements, Department of ICT, MBSTU.*
