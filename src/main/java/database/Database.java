package database;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    String connectionUrl = "jdbc:h2:~/test";
    String connectionLogin = "sa";
    String connectionPass = "";
    public Database() {
        try {
            connection = DriverManager.getConnection(connectionUrl, connectionLogin, connectionPass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }
    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
