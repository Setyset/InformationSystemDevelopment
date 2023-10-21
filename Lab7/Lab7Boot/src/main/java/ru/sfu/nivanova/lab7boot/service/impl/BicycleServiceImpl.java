package ru.sfu.nivanova.lab7boot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.sfu.nivanova.lab7boot.dto.EditBicycleDTO;
import ru.sfu.nivanova.lab7boot.entity.Bicycle;
import ru.sfu.nivanova.lab7boot.repository.BicycleRepository;
import ru.sfu.nivanova.lab7boot.service.BicycleService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BicycleServiceImpl implements BicycleService {

    private final BicycleRepository bicycleRepository;

    @Override
    public Integer add(Bicycle bicycle) {
        this.bicycleRepository.saveAndFlush(bicycle);
        return bicycle.getId();
    }

    @Override
    public Integer add(String manufacturer, String model, String type, Integer size, BigDecimal price, Integer inStock) {
        var bicycle = new Bicycle();
        bicycle.setManufacturer(manufacturer.trim().equals("") ? null : manufacturer);
        bicycle.setModel(model);
        bicycle.setType(type);
        bicycle.setSize(size);
        bicycle.setPrice(price);
        bicycle.setInStock(inStock);
        return this.add(bicycle);
    }

    @Override
    public boolean delete(Integer id) {
        if (!checkId(id)) {
            return false;
        }
        this.bicycleRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Integer id, Integer newInStock, BigDecimal newPrice) {
        var oldBicycle = this.findById(id);
        if (oldBicycle == null) return false;
        if (newPrice != null) {
            oldBicycle.setPrice(newPrice);
        }
        if (newInStock != null) {
            oldBicycle.setInStock(newInStock);
        }
        this.bicycleRepository.save(oldBicycle);
        return true;
    }

    @Override
    public Bicycle patch(Integer id, EditBicycleDTO dto) {
        var bicycle = bicycleRepository.findById(id).orElse(null);
        if (bicycle == null) {
            return null;
        }
        if (dto.getPrice() != null) {
            bicycle.setPrice(dto.getPrice());
        }
        if (dto.getInStock() != null) {
            bicycle.setInStock(dto.getInStock());
        }
        bicycleRepository.save(bicycle);
        return bicycle;
    }

    @Override
    public List<Bicycle> findByMaxPrice(BigDecimal maxPrice) {
        return this.bicycleRepository.findDistinctByPriceLessThan(maxPrice);
    }

    @Override
    public List<Bicycle> findAll() {
        return this.bicycleRepository.findAll(Sort.by("id"));
    }

    @Override
    public Bicycle findById(Integer id) {
        return this.bicycleRepository.findById(id).orElse(null);
    }

    private boolean checkId(Integer id) {
        return id != null && this.bicycleRepository.existsById(id);
    }
}
