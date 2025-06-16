### Problem Statement: **Secure and Controlled Database Access**

You are designing a web application where users can query a database to retrieve sensitive data. However, directly exposing the database access logic could lead to security vulnerabilities, inefficient resource usage, and untracked access.

#### Requirements:

1. **Authentication and Authorization**: Only authenticated users with specific roles (e.g., Admin, User) should access certain data.
2. **Logging and Monitoring**: All database queries must be logged for auditing purposes, including user details, query timestamp, and the query executed.

3. **Lazy Initialization**: Establishing a database connection should happen only when necessary to optimize resource usage.

4. **Query Caching**: Frequently executed queries should be cached to improve performance and reduce database load.

5. **Access Control**: Sensitive data (e.g., salary, personal details) should be masked or restricted based on the user's role.

#### Solution:

Design a **Proxy** that acts as an intermediary between the web application and the database. This proxy should:

- Handle authentication and role-based access control.
- Log all queries and their metadata.
- Initialize the database connection only when a query is executed.
- Cache results for frequently executed queries.
- Apply data masking where necessary.

#### Example Usage:

- A regular user attempts to query the employee database. The proxy checks their role, masks sensitive data, and returns the result.
- An admin user runs the same query, and the proxy provides unmasked data after logging the query.
