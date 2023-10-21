package ru.sfu.nivanova;

import java.math.BigDecimal;

public class Bicycle {
    private Integer id;
    private String manufacturer;
    private String model;
    private String type;
    private Integer size;
    private BigDecimal price;
    private Integer inStock;

    public Bicycle() {
    }

    public Bicycle(Integer id, String manufacturer, String model, String type, Integer size, BigDecimal price, Integer inStock) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.size = size;
        this.price = price;
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    @Override
    public String toString() {
        return "id " + id +
                "\nManufacturer " + manufacturer +
                "\nModel" + model +
                "\nType " + type +
                "\nSize " + size +
                "\nPrice " + String.format("%.2f", price) +
                "\nLeft in stock " + inStock +
                '\n';
    }
}
