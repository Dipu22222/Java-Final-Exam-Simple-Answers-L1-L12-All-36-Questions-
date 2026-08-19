# L8 — Socket Programming & Java RMI (Chat System)

## 8.1 — Socket vs RMI (5 marks)

| Aspect | Socket Programming | Java RMI |
|---|---|---|
| Communication style | Raw byte/text streams over TCP/IP | Remote method invocation — call remote object methods directly |
| Abstraction level | Low-level (manual protocol design) | High-level (feels like a local method call) |
| Language dependency | Language-independent | Java-to-Java only |
| Use case | Simple messaging, cross-language systems (e.g. chat) | Distributed Java applications needing remote object interaction |

**When to prefer:** Use **Sockets** for simple, lightweight, or cross-platform communication like a chat app. Use **RMI** when building distributed Java systems where remote objects need to expose methods as if they were local.

## 8.2 — Server Code (8 marks)

See [`ChatServer.java`](./ChatServer.java) — uses `ServerSocket` to accept a connection, `BufferedReader` to read incoming messages, and `PrintWriter` to reply.

## 8.3 — Client Code (7 marks)

See [`ChatClient.java`](./ChatClient.java) — uses `Socket` to connect, sends a typed message, and prints the server's reply.

**Sample Interaction:**
```
Client: Hello Server
Server: Echo: Hello Server
```
