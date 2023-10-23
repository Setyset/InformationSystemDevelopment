package ru.sfu.nivanova.lab7boot.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EditBicycleDTO {
    private BigDecimal price;
    private Integer inStock;
}
