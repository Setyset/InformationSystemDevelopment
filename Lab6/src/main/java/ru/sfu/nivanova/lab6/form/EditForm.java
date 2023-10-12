package ru.sfu.nivanova.lab6.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class EditForm {
    @NotNull(message = "Can't be null")
    @PositiveOrZero(message = "Can't be negative")
    private int id;

    @NotNull(message = "Can't be null")
    @Positive(message = "Must be positive")
    private BigDecimal price;

    @NotNull(message = "Can't be null")
    @PositiveOrZero(message = "Can't be negative")
    private int inStock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
