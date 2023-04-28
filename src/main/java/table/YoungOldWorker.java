package table;

import java.time.LocalDate;

public class YoungOldWorker {
    final private String type;
    final private String name;
    final private LocalDate date;
    public YoungOldWorker(String type, String name, LocalDate date) {
        this.type = type;
        this.name = name;
        this.date = date;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Young/Old worker: ");
        sb.append("type ='").append(type).append('\'');
        sb.append(", name ='").append(name).append('\'');
        sb.append(", date =").append(date);
        return sb.toString();
    }
}
