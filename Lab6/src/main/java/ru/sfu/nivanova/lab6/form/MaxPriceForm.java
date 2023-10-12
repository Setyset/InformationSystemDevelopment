package ru.sfu.nivanova.lab6.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MaxPriceForm {
    @NotNull(message = "Can't be null")
    @Positive(message = "Must be positive")
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
