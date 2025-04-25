public class Category {
    private int categoryId;
    private String name;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    // Getters and Setters (omitted for brevity)

    @Override
    public String toString() {
        return "ID: " + categoryId + ", Name: " + name;
    }
}
