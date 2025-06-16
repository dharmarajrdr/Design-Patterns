
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Interface defining the executor behavior
interface DatabaseExecutor {

    void execute(Query query);

    List<Map<String, Object>> getRows();
}

// Concrete executor for actual database operations
class DatabaseQueryExecutor implements DatabaseExecutor {

    private List<Map<String, Object>> rows;

    public DatabaseQueryExecutor() {
        this.rows = new ArrayList<>();
    }

    @Override
    public void execute(Query query) {
        // Simulate executing query and fetching results
        System.out.println("Executing query: " + query.getQuery());
        rows.add(Map.of("id", 1, "name", "John Doe", "salary", 100000));
    }

    @Override
    public List<Map<String, Object>> getRows() {
        return this.rows;
    }
}

// Proxy to add logging, access control, and caching
class DatabaseProxy implements DatabaseExecutor {

    private final DatabaseQueryExecutor executor;
    private final Role role;
    private final Map<String, List<Map<String, Object>>> cache;

    public DatabaseProxy(Role role) {
        this.executor = new DatabaseQueryExecutor();
        this.role = role;
        this.cache = new HashMap<>();
    }

    @Override
    public void execute(Query query) {
        if (!authorize(query)) {
            throw new SecurityException("Access denied for role: " + role);
        }

        DatabaseLogger.getInstance().log(query, Level.INFO, role);

        if (query.getQueryMethod() == QueryMethod.SELECT && cache.containsKey(query.getQuery())) {
            System.out.println("Cache hit for query: " + query.getQuery());
        } else {
            executor.execute(query);
            if (query.getQueryMethod() == QueryMethod.SELECT) {
                cache.put(query.getQuery(), executor.getRows());
            }
        }
    }

    @Override
    public List<Map<String, Object>> getRows() {
        List<Map<String, Object>> rows = executor.getRows();
        if (role == Role.USER) {
            return maskSensitiveData(rows);
        }
        return rows;
    }

    private boolean authorize(Query query) {
        // Example: Only ADMIN can perform DELETE or UPDATE
        return role == Role.ADMIN || query.getQueryMethod() == QueryMethod.SELECT;
    }

    private List<Map<String, Object>> maskSensitiveData(List<Map<String, Object>> rows) {
        List<Map<String, Object>> maskedRows = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Map<String, Object> maskedRow = new HashMap<>(row);
            maskedRow.put("salary", "****"); // Mask salary field
            maskedRows.add(maskedRow);
        }
        return maskedRows;
    }
}

// Supporting classes
enum Role {
    ADMIN, USER
}

enum Level {
    INFO, WARNING, ERROR
}

enum QueryMethod {
    INSERT, DELETE, UPDATE, SELECT
}

class DatabaseLogger {

    private static final DatabaseLogger INSTANCE = new DatabaseLogger();

    private DatabaseLogger() {
    }

    public static DatabaseLogger getInstance() {
        return INSTANCE;
    }

    public void log(Query query, Level level, Role role) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(role + " [" + currentDateTime + "] " + level + " - " + query);
    }
}

class Query {

    private final String query;
    private final QueryMethod queryMethod;

    public Query(String query, QueryMethod queryMethod) {
        this.query = query;
        this.queryMethod = queryMethod;
    }

    public String getQuery() {
        return this.query;
    }

    public QueryMethod getQueryMethod() {
        return this.queryMethod;
    }

    @Override
    public String toString() {
        return "Query{"
                + "query='" + query + '\''
                + ", queryMethod=" + queryMethod
                + '}';
    }
}

public class Solution {

    public static void main(String[] args) {
        Role userRole = Role.USER;
        Role adminRole = Role.ADMIN;

        // User role execution
        DatabaseExecutor userProxy = new DatabaseProxy(userRole);
        Query userQuery = new Query("SELECT * FROM employees;", QueryMethod.SELECT);
        userProxy.execute(userQuery);
        System.out.println("User rows: " + userProxy.getRows());

        // Admin role execution
        DatabaseExecutor adminProxy = new DatabaseProxy(adminRole);
        Query adminQuery = new Query("DELETE FROM employees WHERE id=1;", QueryMethod.DELETE);
        try {
            adminProxy.execute(adminQuery);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
