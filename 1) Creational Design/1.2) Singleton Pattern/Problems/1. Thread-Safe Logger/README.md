### Problem Statement: Implement a Thread-Safe Singleton Logger

You are tasked with developing a centralized **logging system** for an enterprise-level application. The logger is responsible for maintaining consistent logging across all components of the application and ensuring efficient performance in a multithreaded environment.

#### **Requirements:**
1. **Singleton Design Pattern Implementation:**
   - Ensure that only a **single instance** of the logger class is created and accessible globally throughout the application lifecycle.

2. **Thread Safety:**
   - The implementation should be **thread-safe**, allowing multiple threads to access the logger instance simultaneously without creating multiple instances or causing race conditions.

3. **Lazy Initialization:**
   - The logger instance should only be created when first accessed, optimizing memory usage and initialization time.

4. **Logging Functionality:**
   - Provide a method `log(String message)` that writes logs to the console or a file. For simplicity, logs can be printed to the console.

5. **Prevention of Singleton Breakage:**
   - Protect against the creation of multiple instances using **serialization** or **reflection**:
     - Prevent multiple instances from being created through deserialization.
     - Prevent multiple instances from being created via reflection.

#### **Expected Behavior:**
- The `Logger` class will provide a static `getInstance()` method to access the Singleton instance.
- The `log(String message)` method will allow application components to log messages.
- The Singleton pattern should enforce a single instance regardless of concurrent access or attempts to bypass the pattern.

#### **Constraints:**
- The logger should not depend on any external framework or library.
- Focus on Java standard libraries and features.
