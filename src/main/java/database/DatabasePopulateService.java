package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static final String POPULATE_DB_SQL_FILE_PATH = "./sql/populate_db.sql";
    public static void main(String[] args) {
        Database date = Database.getInstance();
        try {
            String sqlInit = String.join("\n", Files.readAllLines(Paths.get(POPULATE_DB_SQL_FILE_PATH)));
            date.executeUpdate(sqlInit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            date.close();
        }
    }
}

