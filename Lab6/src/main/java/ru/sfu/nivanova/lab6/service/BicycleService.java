package ru.sfu.nivanova.lab6.service;

import ru.sfu.nivanova.lab6.entity.Bicycle;

import java.math.BigDecimal;
import java.util.List;

public interface BicycleService {
    Integer add(Bicycle apparel);
    Integer add (String apparelType, BigDecimal price, Integer inStock, String size, String sex);
    boolean delete(Integer id);
    Bicycle findById(Integer id);
    boolean update(Integer id, Integer newInStock, BigDecimal newPrice);
    List<Bicycle> findByMaxPrice(Double maxPrice);
    List<Bicycle> findAll();
}
