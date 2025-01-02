**Q1: Why do we use `ConcurrentHashMap` instead of `HashMap` in multithreaded environments?**  
**A:**  
- `HashMap` is not thread-safe, leading to data corruption, race conditions, or inconsistent results in multithreaded scenarios.  
- `ConcurrentHashMap` ensures thread safety by:  
  - Allowing **lock-free reads** (multiple threads can read concurrently without locking).  
  - Using **fine-grained locking** for write operations (only the affected bucket/segment is locked, minimizing contention).  
  - Providing atomic methods like `putIfAbsent()` and `compute()` for consistent updates.  

---

**Q2: How does `ConcurrentHashMap` ensure thread safety?**  
**A:**  
1. **Lock-Free Reads:**  
   - Read operations (`get()`) are lock-free, allowing multiple threads to access data concurrently.  
   - Achieved using **volatile variables** and **non-blocking algorithms**.  

2. **Fine-Grained Locking:**  
   - Write operations (`put()`, `remove()`) lock only the affected portion of the map (a bucket or key-specific lock).  
   - Other threads can safely access or modify other parts of the map simultaneously.  

3. **Atomic Operations:**  
   - Operations like `putIfAbsent()` or `compute()` are atomic, ensuring consistency even when accessed by multiple threads.  

---

**Q3: What happens when multiple threads interact with `ConcurrentHashMap` during configuration loading?**  
**A:**  
1. **Initialization:**  
   - If `configuration` is null, the first thread to acquire the lock initializes it.  
   - Other threads wait for the initialization to complete.  

2. **Concurrent Access:**  
   - Once initialized, multiple threads can safely access or modify the map:  
     - Thread A may read data from one bucket.  
     - Thread B can update another bucket simultaneously without conflict.  

3. **Thread Safety During `put()`:**  
   - When a thread inserts a key-value pair, only the specific bucket being modified is locked, minimizing contention.

---

**Q4: Why not use `HashMap` or `Hashtable`?**  
**A:**  
- **`HashMap`:** Not thread-safe, leading to data corruption during concurrent access.  
- **`Hashtable`:** Thread-safe but uses a global lock for every operation, causing performance bottlenecks under high contention.  
- **`ConcurrentHashMap`:** Combines thread safety with high performance by using fine-grained locking and lock-free reads.  

---

**Q5: How does `ConcurrentHashMap` behave when multiple threads call `refreshConfig()` in the `ConfigurationManager` class?**  
**A:**  
- If `configuration` is null:  
  - The first thread acquires the lock, initializes the map, and loads the configuration.  
  - Other threads wait until the initialization is complete.  
- If `configuration` is already initialized:  
  - Multiple threads can concurrently modify or read the configuration due to `ConcurrentHashMap`'s thread-safety.

---

**Q6: Can you explain the flow of loading configuration with `ConcurrentHashMap`?**  
**A:**  
1. **Clear existing values:**  
   - Remove all previous key-value pairs from `ConcurrentHashMap`.  

2. **Read configuration file:**  
   - Use `getClass().getResourceAsStream(properties_file)` to read the file content as a stream.  

3. **Load properties into memory:**  
   - Use `Properties properties = new Properties(); properties.load(fileContent);` to parse the file into key-value pairs.  

4. **Populate the map:**  
   - Iterate through `properties.stringPropertyNames()` and put each key-value pair into the `ConcurrentHashMap`.  

---

**Q7: Sample Code for Multi-Threaded Configuration Refresh?**  
```java
public class MultiThreadedConfigLoad {

    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Simulate multiple threads refreshing configuration
        Thread thread1 = new Thread(() -> configManager.refreshConfig());
        Thread thread2 = new Thread(() -> configManager.refreshConfig());

        thread1.start();
        thread2.start();
    }
}
```

**What Happens:**  
1. Both threads call `refreshConfig()`.  
2. If `configuration` is null, the first thread initializes it.  
3. After initialization, both threads can safely update or access the `ConcurrentHashMap`.  
