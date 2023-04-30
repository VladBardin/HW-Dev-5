package table;

import java.time.LocalDate;

public class ProjectList {
    private int id;
    private int client_id;
    private LocalDate start_date;
    private LocalDate finish_date;
    public ProjectList(int id, int client_id, LocalDate start_date, LocalDate finish_date) {
        this.id = id;
        this.client_id = client_id;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }
    public int getId() {
        return id;
    }
    public int getClient_id() {
        return client_id;
    }
    public LocalDate getStart_date() {
        return start_date;
    }
    public LocalDate getFinish_date() {
        return finish_date;
    }
}
