package ru.sfu.nivanova.lab7boot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Bicycle {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String manufacturer;

    @Column
    private String model;

    @Column(name = "\"type\"", nullable = false)
    private String type;

    @Column(name = "wheel_size")
    private Integer size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "\"in_stock\"")
    private Integer inStock;

    public Integer getId() {return id; }

    public void setId(Integer id) {this.id = id; }

    public BigDecimal getPrice() {return price; }

    public void setPrice(BigDecimal price) {this.price = price; }

    public Integer getInStock() {return inStock; }

    public void setInStock(Integer inStock) {this.inStock = inStock; }

    public String getType() {
        return type;
    }

    public void setType(String type) {this.type = type; }

    public Integer getSize() {return size; }

    public void setSize(Integer size) {this.size = size; }

    public String getManufacturer() {return manufacturer; }

    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer; }

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
