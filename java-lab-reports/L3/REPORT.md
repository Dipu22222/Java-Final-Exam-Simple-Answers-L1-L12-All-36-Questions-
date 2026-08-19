# L3 — Abstract Class vs Interface

## 3.1 — Definitions and Differences (5 marks)

An **abstract class** is a class declared with the `abstract` keyword that cannot be instantiated and may contain both abstract (unimplemented) and concrete (implemented) methods.

An **interface** is a fully abstract contract (prior to Java 8) that declares method signatures which implementing classes must define; since Java 8 it can also have `default` and `static` methods.

| Aspect | Abstract Class | Interface |
|---|---|---|
| Fields | Can have instance fields with any access modifier | Fields are implicitly `public static final` (constants) |
| Constructors | Can have constructors | Cannot have constructors |
| Method bodies | Can mix abstract and concrete methods | Traditionally all abstract; `default`/`static` allowed since Java 8 |
| Multiple inheritance | A class can extend only one abstract class | A class can implement multiple interfaces |

## 3.2 — When to Choose Which (5 marks)

- Use an **abstract class** for an "is-a" relationship where subclasses share common state or partially implemented behavior.
  *Example:* `Vehicle` (abstract) → `Car`, `Bike` share fields like `speed` and a common `startEngine()` implementation.
- Use an **interface** for a "can-do" capability that unrelated classes might share.
  *Example:* `Insurable` interface implemented by both `Car` and `House`, even though they don't share a common parent class.

## 3.3 — Practical (10 marks)

See [`Vehicle.java`](./Vehicle.java), [`Insurable.java`](./Insurable.java), [`Car.java`](./Car.java), [`Main.java`](./Main.java).

`Vehicle` is abstract because all vehicles share the concrete `startEngine()` logic but differ in `fuelType()`. `Insurable` is an interface because "being insurable" is a capability unrelated to the vehicle hierarchy itself.

**Sample Output:**
```
Engine started.
Fuel Type: Petrol
Insurance Premium: 15000.0
```
