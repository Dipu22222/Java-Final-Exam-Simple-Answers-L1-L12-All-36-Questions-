# L2 — Method Overloading vs Overriding (Early vs Late Binding)

## 2.1 — Overloading vs Overriding (5 marks)

| Aspect | Overloading | Overriding |
|---|---|---|
| Definition | Same method name, different parameter list, in the **same** class | Subclass redefines a method with the **same** signature as its parent |
| Class involved | One class | Two classes (parent–child, via inheritance) |
| Parameters | Must differ (number/type/order) | Must be identical |
| Return type | Can differ | Must be same or covariant |
| Binding time | Compile time (static binding) | Run time (dynamic binding) |

## 2.2 — Early vs Late Binding (5 marks)

- **Early (static) binding:** The compiler decides which method to call at compile time, based on the reference type. Used in overloading, since the compiler can resolve which overload matches the argument list.
- **Late (dynamic) binding:** The JVM decides which method to call at run time, based on the actual object type, not the reference type. Used in overriding, because the actual object (not the declared reference) determines behavior — this enables polymorphism (e.g. a `Shape` reference calling `Circle`'s `area()`).

Overriding must be resolved at run time because the same reference type (e.g. `Shape`) can point to different subclass objects during execution, and the correct version can only be known once the actual object exists.

## 2.3 — Practical (10 marks)

See [`Shape.java`](./Shape.java), [`Circle.java`](./Circle.java), [`Rectangle.java`](./Rectangle.java), [`Main.java`](./Main.java).

**Sample Output:**
```
Describing: MyShape
Describing: MyShape with ID 1
Circle Area: 78.53981633974483
Rectangle Area: 24.0
```
