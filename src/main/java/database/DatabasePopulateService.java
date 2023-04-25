package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static final String POPULATE_DB_SQL_FILE_PATH = "./sql/populate_db.sql";

    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = database.getConnection();
            String sqlInit = String.join("\n", Files.readAllLines(Paths.get(POPULATE_DB_SQL_FILE_PATH)));
            preparedStatement = connection.prepareStatement(sqlInit);
            preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

