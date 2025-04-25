public class StationeryItem {
    private int itemId;
    private String name;
    private String category;
    private String description;
    private int quantity;
    private double unitPrice;
    private Supplier supplier;

    public StationeryItem(int itemId, String name, String category, String description, int quantity, double unitPrice, Supplier supplier) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
    }

    // Getters and Setters (omitted for brevity)

    @Override
    public String toString() {
        return "ID: " + itemId + ", Name: " + name + ", Category: " + category +
               ", Quantity: " + quantity + ", Price: $" + unitPrice +
               (supplier != null ? ", Supplier: " + supplier.getName() : "");
    }
}vvvv
