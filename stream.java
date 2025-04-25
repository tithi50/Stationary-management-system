import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManager {
    private List<StationeryItem> items = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<Supplier> suppliers = new ArrayList<>();
    private int nextItemId = 1;
    private int nextCategoryId = 1;
    private int nextSupplierId = 1;

    public void addItem(StationeryItem item) {
        item.setItemId(nextItemId++);
        items.add(item);
        System.out.println("Item added successfully with ID: " + item.getItemId());
    }

    public StationeryItem viewItem(int itemId) {
        return items.stream()
                    .filter(item -> item.getItemId() == itemId)
                    .findFirst()
                    .orElse(null);
    }

    public void updateItem(StationeryItem updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemId() == updatedItem.getItemId()) {
                items.set(i, updatedItem);
                System.out.println("Item with ID " + updatedItem.getItemId() + " updated.");
                return;
            }
        }
        System.out.println("Item with ID " + updatedItem.getItemId() + " not found.");
    }

    public void deleteItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
        System.out.println("Item with ID " + itemId + " deleted (if found).");
    }

    public void addCategory(Category category) {
        category.setCategoryId(nextCategoryId++);
        categories.add(category);
        System.out.println("Category added successfully with ID: " + category.getCategoryId());
    }

    public Category viewCategory(int categoryId) {
        return categories.stream()
                         .filter(cat -> cat.getCategoryId() == categoryId)
                         .findFirst()
                         .orElse(null);
    }

    // Implement updateCategory, deleteCategory, addSupplier, viewSupplier, etc.

    public void recordStockIn(int itemId, int quantity) {
        StationeryItem item = viewItem(itemId);
        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
            System.out.println("Added " + quantity + " units of " + item.getName() + ". Current stock: " + item.getQuantity());
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    public void recordStockOut(int itemId, int quantity) {
        StationeryItem item = viewItem(itemId);
        if (item != null) {
            if (item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity() - quantity);
                System.out.println("Issued " + quantity + " units of " + item.getName() + ". Current stock: " + item.getQuantity());
            } else {
                System.out.println("Insufficient stock for " + item.getName() + ". Current stock: " + item.getQuantity());
            }
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    public List<StationeryItem> getLowStockItems(int threshold) {
        return items.stream()
                    .filter(item -> item.getQuantity() < threshold)
                    .collect(Collectors.toList());
    }

    public List<StationeryItem> searchItems(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return items.stream()
                    .filter(item -> item.getName().toLowerCase().contains(lowerKeyword) ||
                                   item.getCategory().toLowerCase().contains(lowerKeyword) ||
                                   (item.getSupplier() != null && item.getSupplier().getName().toLowerCase().contains(lowerKeyword)))
                    .collect(Collectors.toList());
    }

    public void generateStockReport() {
        System.out.println("\n--- Current Stock Report ---");
        for (StationeryItem item : items) {
            System.out.println(item);
        }
        System.out.println("---------------------------\n");
    }

    // ... other methods for supplier management and reporting
}
