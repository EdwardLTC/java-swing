package org.example.data.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "inventory")
public class InventoryItem {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, canBeNull = false)
    private Product product;

    @DatabaseField(foreign = true, canBeNull = false)
    private Color color;

    @DatabaseField(foreign = true, canBeNull = false)
    private Size size;

    @DatabaseField(canBeNull = false, defaultValue = "0")
    private int quantity;

    @DatabaseField(canBeNull = false, unique = true)
    private String sku;

    public InventoryItem() {}

    // Getters and setters
    public int getId() { return id; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
}