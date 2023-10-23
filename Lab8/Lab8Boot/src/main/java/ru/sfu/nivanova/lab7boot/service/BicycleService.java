package ru.sfu.nivanova.lab7boot.service;

import ru.sfu.nivanova.lab7boot.dto.EditBicycleDTO;
import ru.sfu.nivanova.lab7boot.entity.Bicycle;

import java.math.BigDecimal;
import java.util.List;

public interface BicycleService {
    Integer add(Bicycle bicycle);
    Integer add (String manufacturer, String model, String type, Integer size, BigDecimal price, Integer inStock);
    boolean delete(Integer id);
    Bicycle findById(Integer id);
    boolean update(Integer id, Integer newInStock, BigDecimal newPrice);

    Bicycle patch(Integer id, EditBicycleDTO dto);

    List<Bicycle> findByMaxPrice(BigDecimal maxPrice);
    List<Bicycle> findAll();
}
