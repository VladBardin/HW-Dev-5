package table;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;
    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" MaxProjectCountClient{ ");
        sb.append("name='").append(name).append('\'');
        sb.append(", projectCount=").append(projectCount);
        sb.append("}\n ");
        return sb.toString();
    }
}
