package org.example.data.models;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Date;

@DatabaseTable(tableName = "products")
public class Product {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField
    private String description;

    @DatabaseField(canBeNull = false)
    private double price;

    @DatabaseField(columnName = "created_at")
    private Date createdAt;

    @DatabaseField(columnName = "deleted_at")
    private Date deletedAt;

    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Brand brand;

    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Category category;

    @ForeignCollectionField(eager = false)
    private ForeignCollection<Variant> variants;

    public Product() {}

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Date getCreatedAt() { return createdAt; }
    public void setDeletedAt(Date deletedAt) { this.deletedAt = deletedAt; }
    public Date getDeletedAt() { return deletedAt; }

    public ForeignCollection<Variant> getVariants() { return variants; }
}
