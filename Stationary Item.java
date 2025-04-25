classDiagram
    class StationeryItem {
        -itemId: int
        -name: String
        -category: String
        -description: String
        -quantity: int
        -unitPrice: double
        -supplier: Supplier
        +StationeryItem(int, String, String, String, int, double, Supplier)
        +getItemId(): int
        +getName(): String
        +getCategory(): String
        +getDescription(): String
        +getQuantity(): int
        +setQuantity(int): void
        +getUnitPrice(): double
        +setUnitPrice(double): void
        +getSupplier(): Supplier
        +setSupplier(Supplier): void
        +toString(): String
    }

    class Category {
        -categoryId: int
        -name: String
        +Category(int, String)
        +getCategoryId(): int
        +getName(): String
        +setName(String): void
        +toString(): String
    }

    class Supplier {
        -supplierId: int
        -name: String
        -contactInfo: String
        +Supplier(int, String, String)
        +getSupplierId(): int
        +getName(): String
        +setName(String): void
        +getContactInfo(): String
        +setContactInfo(String): void
        +toString(): String
    }

    class InventoryManager {
        -items: List<StationeryItem>
        -categories: List<Category>
        -suppliers: List<Supplier>
        +addItem(StationeryItem): void
        +viewItem(int): StationeryItem
        +updateItem(StationeryItem): void
        +deleteItem(int): void
        +addCategory(Category): void
        +viewCategory(int): Category
        +updateCategory(Category): void
        +deleteCategory(int): void
        +addSupplier(Supplier): void
        +viewSupplier(int): Supplier
        +updateSupplier(Supplier): void
        +deleteSupplier(int): void
        +recordStockIn(int, int): void
        +recordStockOut(int, int): void
        +getLowStockItems(int): List<StationeryItem>
        +searchItems(String): List<StationeryItem>
        +generateStockReport(): void
        // ... other methods
    }

    StationeryItem "1" -- "*" InventoryManager : manages
    Category "1" -- "*" InventoryManager : manages
    Supplier "1" -- "*" StationeryItem : supplies
    Supplier "1" -- "*" InventoryManager : manages
