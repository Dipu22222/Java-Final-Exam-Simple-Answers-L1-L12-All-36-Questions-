# L1 — Encapsulation and Polymorphism

**Course:** ICT 2208 — Object Oriented Pattern and Design Lab
**Submitted by:** Dipu Mondol (IT24040)

---

## 1.1 — What is encapsulation? (5 marks)

Encapsulation is the process of binding data (fields) and the methods that operate on that data into a single unit (class), while restricting direct access to the internal state from outside the class. In Java it is achieved by:

- Declaring fields as `private`.
- Providing controlled access through `public` **getter** and **setter** methods.
- Optionally validating data inside setters before it is assigned.

**Real-life analogy:** A capsule medicine hides its internal chemical contents inside a shell — you interact with it (swallow it) without directly touching or altering its internal ingredients. Similarly, a class hides its internal data and only exposes safe, controlled methods to interact with it.

## 1.2 — What is polymorphism? (5 marks)

Polymorphism means "many forms" — the ability of an object or method to behave differently depending on context.

| | Compile-time (Static) | Run-time (Dynamic) |
|---|---|---|
| Achieved by | Method Overloading | Method Overriding |
| Resolved at | Compile time | Run time |
| Example | `add(int,int)` vs `add(double,double)` | `Shape` reference calling overridden `area()` of `Circle` |

**Example (compile-time):**
```java
void add(int a, int b) { }
void add(double a, double b) { }
```

**Example (run-time):**
```java
Shape s = new Circle();
s.area(); // calls Circle's overridden version at run time
```

## 1.3 — Practical (10 marks)

See [`BankAccount.java`](./BankAccount.java). Demonstrates:
- **Encapsulation:** `balance` is `private`, accessed only via `getBalance()` and `deposit()`.
- **Polymorphism (overloading):** `deposit(double)` and `deposit(double, String remarks)`.

**Sample Output:**
```
Deposited: 5000.0 | Balance: 5000.0
Deposited: 2000.0 (Remarks: Salary) | Balance: 7000.0
Final Balance: 7000.0
```
