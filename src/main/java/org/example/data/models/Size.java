package org.example.data.models;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sizes")
public class Size {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, unique = true)
    private double usSize;

    @DatabaseField(canBeNull = false)
    private double euSize;

    @DatabaseField
    private char gender; // M, F, or U

    public Size() {}

    // Getters and setters
    public int getId() { return id; }
    public double getUsSize() { return usSize; }
    public void setUsSize(double usSize) { this.usSize = usSize; }
    public double getEuSize() { return euSize; }
    public void setEuSize(double euSize) { this.euSize = euSize; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
}