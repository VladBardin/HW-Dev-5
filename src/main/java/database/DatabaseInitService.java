package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static final String INIT_DB_SQL_FILE_PATH = "./sql/init_db.sql";
    public static void main(String[] args) throws IOException, SQLException {
        Database db = Database.getInstance();
        try {
            String sqlInit = String.join("\n", Files.readAllLines(Paths.get(INIT_DB_SQL_FILE_PATH)));
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlInit);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            db.close();
        }
    }
}
