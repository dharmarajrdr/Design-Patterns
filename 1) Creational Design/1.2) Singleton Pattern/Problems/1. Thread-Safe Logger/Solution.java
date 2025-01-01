
enum Level {
    // Ordinal : 0, 1, 2
    INFO, WARNING, ERROR
}

enum Logger {   // Enums are thread safe. This is one of the best way to achieve the singleton design patterm
    INSTANCE;

    private Level currentLevel = Level.WARNING;

    public void setLogLevel(Level level) {
        this.currentLevel = level;
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void log(String message, Level level) {
        if (message == null || level == null) {
            throw new IllegalArgumentException("Message and Level cannot be null");
        }
        if (level.ordinal() >= currentLevel.ordinal()) {    // level.ordinal = 0 for INFO. CurrentLevel.ordinal = 1 for WARNING.
            System.out.println(level + " : " + message);
        }
    }
}

public class Solution {

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        logger.setLogLevel(Level.WARNING);  // Log only Warnings and severity greater than Warnings.

        try {
            logger.log("This is an info message", Level.INFO);      // Will not be logged
            logger.log("This is a warning message", Level.WARNING); // Will be logged
            logger.log("This is an error message", Level.ERROR);    // Will be logged
        } catch (Exception e) {
            logger.log("Issue in main method", Level.ERROR);
        }
    }
}
