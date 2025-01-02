### Problem Statement: **Application Configuration Manager**

Design a Singleton class for managing the configuration settings of an application. The configuration settings are stored in a file (`config.properties`), and the class should ensure:

1. There is only one instance of the configuration manager throughout the application.
2. The configuration file is loaded only once, even in a multithreaded environment.
3. The class provides methods to:
   - Retrieve a configuration value by its key.
   - Refresh the configuration by reloading the file.

---

### Functional Requirements:
1. The configuration file (`config.properties`) contains key-value pairs, e.g.,:
   ```
   app.name=MyApp
   app.version=1.0
   app.theme=dark
   ```
2. Provide a `getConfigValue(String key)` method to fetch a value by its key.
3. Provide a `refreshConfig()` method to reload the file in case the configuration changes during runtime.
4. Ensure thread safety when accessing or refreshing the configuration.

---

### Constraints:
1. The Singleton class must prevent instantiation from reflection or serialization.
2. It must support concurrent reads while maintaining a single instance.

---

### Example Usage:
```java
public class Application {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Fetch configuration values
        System.out.println("App Name: " + configManager.getConfigValue("app.name"));
        System.out.println("App Version: " + configManager.getConfigValue("app.version"));

        // Simulate configuration refresh
        configManager.refreshConfig();
    }
}
```

---

### Expected Output (Based on the `config.properties` file):
```
App Name: MyApp
App Version: 1.0
```

---

### Hints:
- Use a thread-safe mechanism (e.g., `synchronized` or `volatile`) to ensure the Singleton instance is initialized correctly.
- Load the configuration file once when the Singleton instance is created.
- Use `Properties` or `Map` to store key-value pairs from the configuration file.
