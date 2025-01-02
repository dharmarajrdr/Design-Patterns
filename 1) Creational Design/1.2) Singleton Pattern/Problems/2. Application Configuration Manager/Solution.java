
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

class ConfigurationManager {

    private static final ConcurrentHashMap<String, String> configuration = new ConcurrentHashMap<>();
    private static final String CONFIG_FILE = "/application.properties";    // The file should be in the application's classpath.

    private ConfigurationManager() {
        loadConfiguration();
    }

    private static class ConfigurationManagerInstance {

        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    public static ConfigurationManager getInstance() {
        return ConfigurationManagerInstance.INSTANCE;
    }

    private void loadConfiguration() {
        try (InputStream input = getClass().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalArgumentException("Configuration file not found: " + CONFIG_FILE);
            }

            Properties properties = new Properties();
            properties.load(input);

            configuration.clear();
            for (String key : properties.stringPropertyNames()) {
                configuration.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public String getConfigValue(String key) {
        return configuration.getOrDefault(key, "Default Value"); // Return default value if key is not found
    }

    public void refreshConfig() {
        loadConfiguration();
    }
}

public class Solution {

    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Fetch configuration values
        System.out.println("App Name: " + configManager.getConfigValue("app.name"));
        System.out.println("App Version: " + configManager.getConfigValue("app.version"));

        // Simulate configuration refresh
        configManager.refreshConfig();
    }
}
