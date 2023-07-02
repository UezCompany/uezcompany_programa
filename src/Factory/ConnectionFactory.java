package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost/uezdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            // Trate a exceção de fechamento da conexão conforme a necessidade
            exception.printStackTrace();
        }
    }
}
