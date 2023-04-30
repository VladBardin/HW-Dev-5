package database;

import table.ClientList;
import table.ProjectList;
import table.ProjectWorkerList;
import table.WorkerList;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DatabasePopulateService {
    private Database database;
    public DatabasePopulateService(Database database) {
        this.database = database;
    }
    public static final String POPULATE_DB_SQL_FILE_PATH = "./sql/populate_db.sql";
    public static void main(String[] args) throws SQLException, IOException {
        Path path = Paths.get(POPULATE_DB_SQL_FILE_PATH);
        List<WorkerList> workerLists = Arrays.asList((WorkerList) path);
        List<ClientList> clientLists = Arrays.asList((ClientList) path);
        List<ProjectList> projectLists = Arrays.asList((ProjectList) path);
        List<ProjectWorkerList> projectWorkerLists= Arrays.asList((ProjectWorkerList) path);
        DatabasePopulateService populateService = new DatabasePopulateService(Database.getInstance());
        populateService.insertWorker(workerLists);
        populateService.insertClients(clientLists);
        populateService.insertProjects(projectLists);
        populateService.insertProjectsWorkers(projectWorkerLists);
    }
    public void insertWorker(List<WorkerList> workerLists) {
        try (PreparedStatement insertIntoWorkerSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (? , ? , ? , ? )")) {
            for (int i = 0; i < workerLists.size(); i++) {
                insertIntoWorkerSt.setString(1, workerLists.get(i).getName());
                insertIntoWorkerSt.setString(2, workerLists.get(i).getBirthday().toString());
                insertIntoWorkerSt.setString(3, workerLists.get(i).getLevel());
                insertIntoWorkerSt.setInt(4, workerLists.get(i).getSalary());
                insertIntoWorkerSt.addBatch();
            }
            insertIntoWorkerSt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertClients(List<ClientList> clientLists) {
        try (PreparedStatement insertIntoClientSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO client (name) VALUES (?)")) {
            for (int i = 0; i < clientLists.size(); i++) {
                insertIntoClientSt.setString(1, clientLists.get(i).getName());
                insertIntoClientSt.addBatch();
            }
            insertIntoClientSt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void insertProjects(List<ProjectList> projectLists) {
        try (PreparedStatement insertIntoProjectSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES ( ?, ?, ?)")) {
            for (int i = 0; i < projectLists.size(); i++) {
                insertIntoProjectSt.setInt(1, projectLists.get(i).getClient_id());
                insertIntoProjectSt.setString(2, projectLists.get(i).getStart_date().toString());
                insertIntoProjectSt.setString(3, projectLists.get(i).getFinish_date().toString());
                insertIntoProjectSt.addBatch();
            }
            insertIntoProjectSt.executeBatch();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void insertProjectsWorkers(List<ProjectWorkerList> projectWorkerLists) {
        try (PreparedStatement insertIntoProjectWorkerSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES ( ? , ? )")) {
            for (int i = 0; i < projectWorkerLists.size(); i++) {
                insertIntoProjectWorkerSt.setInt(1, projectWorkerLists.get(i).getProject_id());
                insertIntoProjectWorkerSt.setInt(2, projectWorkerLists.get(i).getWorker_id());
                insertIntoProjectWorkerSt.addBatch();
            }
            insertIntoProjectWorkerSt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

