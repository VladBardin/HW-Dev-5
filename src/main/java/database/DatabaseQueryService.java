package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import table.*;

public class DatabaseQueryService {
    public static final String FIND_MAX_PR_CL = "./sql/find_max_projects_client.sql";
    public static final String FIND_MAX_SALARY = "./sql/find_max_salary_worker.sql";
    public static final String FIND_LONGEST_Pr = "./sql/find_longest_project.sql";
    public static final String FIND_YOUNG_OLD_WORKER = "./sql/find_youngest_eldest_workers.sql";
    public static final String PRINT_PR_PRICES = "./sql/print_project_prices.sql";
    public List<MaxSalary> findMaxSalary() throws IOException {
        List<MaxSalary> maxSalaryList = new ArrayList<>();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_MAX_SALARY)));
        Database date = new Database();
        try (Statement st = date.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)
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
    public List<MaxProjectCountClient> findMaxProjectCountClient() throws IOException {
        List<MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_MAX_PR_CL)));
        Database date = new Database();
        try (Statement st = date.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)
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
    public List<LongestPrice> findLongestPrices() throws IOException {
        List<LongestPrice> longestPriceList = new ArrayList<>();
        Database date = new Database();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_LONGEST_Pr)));
        try (Statement st = date.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                longestPriceList.add(new LongestPrice(rs.getInt("ID"), rs.getInt("MONTH_COUNT")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return longestPriceList;
    }
    public List<YoungOldWorker> findYoungOldWorker() throws IOException {
        List<YoungOldWorker> youngOldWorkerList = new ArrayList<>();
        Database date = new Database();
        String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_YOUNG_OLD_WORKER)));
        try (Statement st = date.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)
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
    public List<ProjectPrice> printProjectPrice() throws IOException {
        List<ProjectPrice> projectPriceList = new ArrayList<>();
        Database date = new Database();
        String sql = String.join("\n", Files.readAllLines(Paths.get(PRINT_PR_PRICES)));
        try (Statement st = date.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                projectPriceList.add(new ProjectPrice(rs.getInt("PROJECT_ID"), rs.getInt("PRICE")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }finally {
            date.close();
        }
        return projectPriceList;
    }
}


