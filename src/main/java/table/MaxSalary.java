package table;

public class MaxSalary {
    private String name;
    private int salary;
    public MaxSalary(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MaxSalary{");
        sb.append(" name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append("} \n ");
        return sb.toString();
    }
}
