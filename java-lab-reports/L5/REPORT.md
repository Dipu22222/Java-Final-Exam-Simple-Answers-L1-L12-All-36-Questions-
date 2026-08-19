# L5 — Multithreading & Custom Exception Handling

## 5.1 — Ways to Implement Multithreading (5 marks)

1. **Extending the `Thread` class** and overriding `run()`.
2. **Implementing the `Runnable` interface** and passing it to a `Thread` object.
3. **Using `ExecutorService` with `Callable`/`Runnable`** for managed thread pools, which can also return results via `Future`.

**Preferred:** Implementing `Runnable` (or using `ExecutorService`) is generally preferred because Java supports single inheritance — extending `Thread` uses up the one available superclass slot, while implementing `Runnable` leaves the class free to extend another class. `ExecutorService` is further preferred in real applications because it manages thread lifecycle and pooling efficiently.

## 5.2 — Practical: Two Threads (5 marks)

See [`MultithreadingDemo.java`](./MultithreadingDemo.java). One thread extends `Thread`, the other implements `Runnable`; both are started from `main()` using `.start()`.

**Sample Output (interleaving may vary):**
```
[Thread-A] 1
[Thread-B] 1
[Thread-A] 2
[Thread-B] 2
...
```

## 5.3 — Practical: Custom Exception (10 marks)

See [`CustomExceptionDemo.java`](./CustomExceptionDemo.java). `InvalidRadiusException` is a checked exception thrown by the `Circle` constructor when `radius < 0`.

**Sample Output:**
```
Error: Radius cannot be negative.
Area: 78.53981633974483
```
