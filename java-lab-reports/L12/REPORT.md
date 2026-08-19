# L12 — GoF Design Patterns

## 12.1 — Creational Patterns (6 marks)

| Pattern | Purpose |
|---|---|
| Singleton | Ensures a class has only one instance and provides a global access point to it |
| Factory Method | Defines an interface for creating an object, letting subclasses decide which class to instantiate |
| Abstract Factory | Produces families of related objects without specifying their concrete classes |
| Builder | Constructs a complex object step-by-step, separating construction from representation |
| Prototype | Creates new objects by cloning an existing instance rather than instantiating from scratch |

## 12.2 — Structural Patterns (7 marks)

| Pattern | Purpose |
|---|---|
| Adapter | Converts one interface into another that a client expects |
| Bridge | Decouples an abstraction from its implementation so both can vary independently |
| Composite | Composes objects into tree structures to treat individual objects and compositions uniformly |
| Decorator | Adds new responsibilities to an object dynamically without altering its structure |
| Facade | Provides a simplified, unified interface to a complex subsystem |
| Flyweight | Shares common state across many objects to reduce memory usage |
| Proxy | Provides a placeholder/surrogate to control access to another object |

## 12.3 — Practical: Singleton & Adapter (7 marks)

See [`Singleton.java`](./Singleton.java) (thread-safe via double-checked locking) and [`Adapter.java`](./Adapter.java) (classic MediaPlayer → AdvancedMediaPlayer adapter).
