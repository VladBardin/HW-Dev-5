package table;

public class LongestProject {
    private int id;
    private int duration;
    public LongestProject(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindLongestPr = ");
        sb.append("id=").append(id);
        sb.append(", duration=").append(duration);
        //sb.append(" \n");
        return sb.toString();
    }
}
