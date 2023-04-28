package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import table.*;

public class DatabaseQueryService {
    public static String FIND_MAX_SALARY = "./sql/find_max_salary_worker.sql";
    public static String FIND_YOUNG_OLD_WORKER = "./sql/find_youngest_eldest_workers.sql";
   public static String FIND_MAX_PROJECT_CLIENT = "./sql/find_max_projects_client.sql";
   public static String FIND_LONGEST_PROJECT = "./sql/find_longest_project.sql";
   public static String PRINT_PROJECT_PRICES = "./sql/print_project_prices.sql";
    public List<MaxSalary> findMaxSalary() throws IOException {
        List<MaxSalary> maxSalaryList = new ArrayList<>();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_MAX_SALARY)));
        Database date = new Database();
        try (PreparedStatement st = date.getConnection().prepareStatement(sql);
             ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                maxSalaryList.add(new MaxSalary(rs.getInt("SALARY"), rs.getString("NAME")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return maxSalaryList;
    }
    public List<MaxProjectCountClient> findMaxPrCtClient() throws IOException {
        List<MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_MAX_PROJECT_CLIENT)));
        Database date = new Database();
        try (PreparedStatement st = date.getConnection().prepareStatement(sql);
             ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                maxProjectCountClientList.add(new MaxProjectCountClient(rs.getString("NAME"), rs.getInt("PROJECT_COUNT")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return maxProjectCountClientList;
    }
    public List<LongestProject> findLongestPrs() throws IOException {
        List<LongestProject> longestPrList = new ArrayList<>();
        Database date = new Database();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_LONGEST_PROJECT)));
        try (PreparedStatement st = date.getConnection().prepareStatement(sql);
             ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                longestPrList.add(new LongestProject(rs.getInt("ID"), rs.getInt("MONTH_COUNT")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return longestPrList;
    }
    public List<YoungOldWorker> findYoungOldWorker() throws IOException {
        List<YoungOldWorker> youngOldWorkerList = new ArrayList<>();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_YOUNG_OLD_WORKER)));
        Database date = new Database();
        try (PreparedStatement st = date.getConnection().prepareStatement(sql);
             ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                youngOldWorkerList.add(new YoungOldWorker(rs.getString("TYPE"), rs.getString("NAME"), LocalDate.parse(rs.getString("BIRTHDAY"))));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return youngOldWorkerList;
    }
    public List<MaxSalary> printProjectPrice() throws IOException {
        List<MaxSalary> maxSalaryList = new ArrayList<>();
        String sql = String.join("\n", Files.readAllLines(Paths.get(PRINT_PROJECT_PRICES)));
        Database date = new Database();
        try (PreparedStatement st = date.getConnection().prepareStatement(sql);
             ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                maxSalaryList.add(new MaxSalary(rs.getInt("PROJECT_ID"), rs.getString("PRICE")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return maxSalaryList;
    }
}


