import java.sql.*;

class DBConnection {
    static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "WJ28@krhps"
        );
    }
}