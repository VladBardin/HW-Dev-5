package table;

public class ProjectPrice {
    private int prID;
    private int price;
    public ProjectPrice(int prID, int price) {
        this.prID = prID;
        this.price = price;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project price: ");
        sb.append("projectID = ").append(prID);
        sb.append(", price = ").append(price);
        return sb.toString();
    }
}
