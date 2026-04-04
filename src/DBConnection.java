import java.sql.*;

class DBConnection {
    static Connection getConnection() throws Exception {

        // Step 1: Connect without database
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "WJ28@krhps"
        );

        Statement stmt = conn.createStatement();

        // Step 2: Create database if not exists
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS studentdb");

        // Step 3: Connect to studentdb
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "WJ28@krhps"
        );

        stmt = conn.createStatement();

        // Step 4: Create table if not exists
        stmt.executeUpdate(
            "CREATE TABLE IF NOT EXISTS students (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(50), " +
            "course VARCHAR(50), " +
            "regno VARCHAR(20), " +
            "email VARCHAR(50))"
        );

        return conn;
    }
}