import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// ============================================================
//  SingletonDemo.java
//  Written by Muhammad Samudera Bagja, SDUST 2026 Spring Class

//  Demonstrates the Singleton Design Pattern using:
//    - DatabaseConfig  (Singleton)
//    - ConnectionPool  (Singleton)
//    - Connection
//    - ResultSet
// ============================================================

// ─────────────────────────────────────────────────────────────
// 1.  ResultSet  – holds query result rows
// ─────────────────────────────────────────────────────────────
class ResultSet {
    private List<Map<String, String>> data;
    private int rowCount;
    private int currentRow;

    public ResultSet(List<Map<String, String>> data) {
        this.data       = data;
        this.rowCount   = data.size();
        this.currentRow = -1;
    }

    public List<Map<String, String>> getData()   { return data; }
    public int getRowCount()                     { return rowCount; }

    /** Advance cursor to next row; returns false when exhausted. */
    public boolean next() {
        currentRow++;
        return currentRow < rowCount;
    }

    public String getString(String column) {
        if (currentRow < 0 || currentRow >= rowCount) return null;
        return data.get(currentRow).getOrDefault(column, null);
    }

    public void close() {
        data       = Collections.emptyList();
        currentRow = -1;
        System.out.println("    [ResultSet] Closed.");
    }
}

// ─────────────────────────────────────────────────────────────
// 2.  Connection  – represents a single DB connection
// ─────────────────────────────────────────────────────────────
class Connection {
    private final String    connectionId;
    private boolean         isActive;
    private final LocalDateTime createdAt;

    public Connection() {
        this.connectionId = "CONN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.isActive     = false;
        this.createdAt    = LocalDateTime.now();
    }

    public void open() {
        isActive = true;
        System.out.println("    [Connection] " + connectionId + " opened at "
                + createdAt.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public void close() {
        isActive = false;
        System.out.println("    [Connection] " + connectionId + " closed.");
    }

    public ResultSet executeQuery(String sql) {
        System.out.println("    [Connection] " + connectionId + " executing: " + sql);
        // Simulate result rows
        List<Map<String, String>> rows = new ArrayList<>();
        Map<String, String> r1 = new LinkedHashMap<>();
        r1.put("id", "1"); r1.put("name", "Alice"); r1.put("role", "Admin");
        Map<String, String> r2 = new LinkedHashMap<>();
        r2.put("id", "2"); r2.put("name", "Bob");   r2.put("role", "User");
        rows.add(r1); rows.add(r2);
        return new ResultSet(rows);
    }

    public boolean isActive()         { return isActive; }
    public String  getConnectionId()  { return connectionId; }
}

// ─────────────────────────────────────────────────────────────
// 3.  DatabaseConfig  ── SINGLETON ──
//     Holds all DB settings; only ONE instance ever exists.
// ─────────────────────────────────────────────────────────────
class DatabaseConfig {

    // ★ Static field that holds the single instance
    private static DatabaseConfig instance;

    // Configuration fields
    private final String host;
    private final int    port;
    private final String databaseName;
    private final String username;
    private final String password;
    private final int    maxPoolSize;

    // ★ Private constructor – prevents direct instantiation
    private DatabaseConfig() {
        this.host         = "localhost";
        this.port         = 5432;
        this.databaseName = "app_db";
        this.username     = "admin";
        this.password     = "s3cr3t";
        this.maxPoolSize  = 10;
        System.out.println("  [DatabaseConfig] Instance created (private constructor called once).");
    }

    // ★ Public static accessor – lazy initialization + thread-safe
    public static synchronized DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();   // created only the FIRST time
        }
        return instance;
    }

    public String getHost()         { return host; }
    public int    getPort()         { return port; }
    public String getDatabaseName() { return databaseName; }
    public String getUsername()     { return username; }
    public int    getMaxPoolSize()  { return maxPoolSize; }

    @Override
    public String toString() {
        return String.format("DatabaseConfig{host='%s', port=%d, db='%s', user='%s', maxPool=%d}",
                host, port, databaseName, username, maxPoolSize);
    }
}

// ─────────────────────────────────────────────────────────────
// 4.  ConnectionPool  ── SINGLETON ──
//     Manages a pool of Connection objects.
//     Uses DatabaseConfig singleton for configuration.
// ─────────────────────────────────────────────────────────────
class ConnectionPool {

    // ★ Static field that holds the single instance
    private static ConnectionPool instance;

    private int              activeConnections;
    private final List<Connection> connectionList;
    private final DatabaseConfig   config;           // uses the other Singleton

    // ★ Private constructor – prevents direct instantiation
    private ConnectionPool() {
        this.config            = DatabaseConfig.getInstance();  // reuses the same singleton
        this.connectionList    = new ArrayList<>();
        this.activeConnections = 0;
        System.out.println("  [ConnectionPool] Instance created (maxPoolSize=" + config.getMaxPoolSize() + ").");
    }

    // ★ Public static accessor – lazy initialization + thread-safe
    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();   // created only the FIRST time
        }
        return instance;
    }

    /** Borrow a connection from the pool (creates one if needed and pool not full). */
    public Connection getConnection() {
        if (isPoolFull()) {
            System.out.println("    [ConnectionPool] Pool is FULL (" + config.getMaxPoolSize() + " connections). Cannot create more.");
            return null;
        }
        Connection conn = new Connection();
        conn.open();
        connectionList.add(conn);
        activeConnections++;
        System.out.println("    [ConnectionPool] Active connections: " + activeConnections);
        return conn;
    }

    /** Return a connection to the pool. */
    public void releaseConnection(Connection conn) {
        if (conn != null && connectionList.remove(conn)) {
            conn.close();
            activeConnections--;
            System.out.println("    [ConnectionPool] Connection released. Active: " + activeConnections);
        }
    }

    public int     getActiveCount() { return activeConnections; }
    public boolean isPoolFull()     { return activeConnections >= config.getMaxPoolSize(); }

    /** Close all connections and shut down the pool. */
    public void shutdown() {
        System.out.println("  [ConnectionPool] Shutting down...");
        for (Connection conn : new ArrayList<>(connectionList)) {
            releaseConnection(conn);
        }
        System.out.println("  [ConnectionPool] All connections closed.");
    }
}

// ─────────────────────────────────────────────────────────────
// 5.  Application  – entry point; uses both singletons
// ─────────────────────────────────────────────────────────────
class Application {
    private final String appName;
    private final String version;

    public Application(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }

    public void run() {
        System.out.println("\n========================================");
        System.out.println("  " + appName + " v" + version + " starting...");
        System.out.println("========================================\n");

        // ── Retrieve Singletons ──────────────────────────────
        System.out.println("► Fetching DatabaseConfig singleton...");
        DatabaseConfig dbConfig = DatabaseConfig.getInstance();
        System.out.println("  Config: " + dbConfig);

        System.out.println("\n► Fetching DatabaseConfig singleton again (same object?)...");
        DatabaseConfig dbConfig2 = DatabaseConfig.getInstance();
        System.out.println("  Same instance: " + (dbConfig == dbConfig2));   // must be TRUE

        System.out.println("\n► Fetching ConnectionPool singleton...");
        ConnectionPool pool = ConnectionPool.getInstance();

        System.out.println("\n► Fetching ConnectionPool singleton again (same object?)...");
        ConnectionPool pool2 = ConnectionPool.getInstance();
        System.out.println("  Same instance: " + (pool == pool2));           // must be TRUE

        // ── Use pool to obtain a connection and run a query ───
        System.out.println("\n► Borrowing a connection from the pool...");
        Connection conn1 = pool.getConnection();

        System.out.println("\n► Executing a query...");
        if (conn1 != null) {
            ResultSet rs = conn1.executeQuery("SELECT id, name, role FROM users");
            System.out.println("    Query returned " + rs.getRowCount() + " row(s):");
            while (rs.next()) {
                System.out.printf("      id=%-3s name=%-8s role=%s%n",
                        rs.getString("id"), rs.getString("name"), rs.getString("role"));
            }
            rs.close();
        }

        System.out.println("\n► Borrowing a second connection...");
        Connection conn2 = pool.getConnection();

        System.out.println("\n► Pool active count: " + pool.getActiveCount());

        // ── Release connections and shutdown ──────────────────
        System.out.println("\n► Releasing conn1...");
        pool.releaseConnection(conn1);

        System.out.println("\n► Shutting down pool...");
        pool.shutdown();

        System.out.println("\n========================================");
        System.out.println("  Application finished.");
        System.out.println("========================================");
    }

    // ─── main ───────────────────────────────────────────────
    public static void main(String[] args) {
        Application app = new Application("SingletonDemo", "1.0.0");
        app.run();
    }
}
