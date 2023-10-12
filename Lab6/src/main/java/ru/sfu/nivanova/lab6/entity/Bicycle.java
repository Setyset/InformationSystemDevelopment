package ru.sfu.nivanova.lab6.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Bicycle {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "\"inStock\"", nullable = false)
    private Integer inStock;

    @Column(name = "\"bicycleType\"", nullable = false)
    private String bicycleType;

    @Column
    private String size;

    @Column
    private String manufacturer;

    public Bicycle() {
    }

    public Bicycle(Integer id, BigDecimal price, Integer inStock, String bicycleType, String size, String manufacturer) {
        this.id = id;
        this.price = price;
        this.inStock = inStock;
        this.bicycleType = bicycleType;
        this.size = size;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(String apparelType) {
        this.bicycleType = apparelType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "id " + id +
                "\nType " + bicycleType +
                "\nSex " + manufacturer +
                "\nSize " + size +
                "\nPrice " + String.format("%.2f", price) +
                "\nLeft in stock " + inStock +
                '\n';
    }
}
