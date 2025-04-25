public class Supplier {
    private int supplierId;
    private String name;
    private String contactInfo;

    public Supplier(int supplierId, String name, String contactInfo) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters (omitted for brevity)

    @Override
    public String toString() {
        return "ID: " + supplierId + ", Name: " + name + ", Contact: " + contactInfo;
    }
}
