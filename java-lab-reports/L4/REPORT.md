# L4 — Collection Framework

## 4.1 — ArrayList vs Vector vs LinkedList (5 marks)

| Aspect | ArrayList | Vector | LinkedList |
|---|---|---|---|
| Underlying structure | Dynamic array | Dynamic array | Doubly linked list |
| Synchronization | Not synchronized | Synchronized (thread-safe) | Not synchronized |
| Random access (get) | Fast — O(1) | Fast — O(1) | Slow — O(n) |
| Insert/delete (middle) | Slow — requires shifting | Slow — requires shifting | Fast — O(1) once position found |

## 4.2 — Set and Its Implementations (5 marks)

A `Set` is a collection that does **not** allow duplicate elements.

- **HashSet:** Backed by a hash table; no guaranteed order; fastest for add/search/remove.
- **LinkedHashSet:** Maintains insertion order using a linked list alongside the hash table.
- **TreeSet:** Backed by a Red-Black tree (a `TreeMap` internally); automatically keeps elements in **sorted order** by using natural ordering (`Comparable`) or a supplied `Comparator`, so every insertion places the element at its correct sorted position.

## 4.3 — Practical (10 marks)

See [`CollectionDemo.java`](./CollectionDemo.java).

**Sample Output:**
```
ArrayList (insertion order): Rakib, Karim, Anika, Zayan, Bithi
TreeSet (sorted order): Anika, Bithi, Karim, Rakib, Zayan
```

**Comment:** The `ArrayList` preserves the order in which names were added, while the `TreeSet` automatically reorders them alphabetically, since `TreeSet` maintains natural (sorted) ordering rather than insertion order.
