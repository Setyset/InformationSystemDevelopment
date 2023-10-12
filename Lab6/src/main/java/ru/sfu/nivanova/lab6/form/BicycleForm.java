package ru.sfu.nivanova.lab6.form;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class BicycleForm {
    @NotBlank(message = "Can't be blank")
    private String type;

    private String size;

    @Size(max = 1)
    private String manufacturer;

    @NotNull(message = "Can't be null")
    @Positive(message = "Must be positive")
    private BigDecimal price;

    @NotNull(message = "Can't be null")
    @PositiveOrZero(message = "Can't be negative")
    private int inStock;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
