package ru.sfu.nivanova.lab6.service.impl;

import ru.sfu.nivanova.lab6.entity.Bicycle;
import ru.sfu.nivanova.lab6.repository.BicycleRepository;
import ru.sfu.nivanova.lab6.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BicycleServiceImpl implements BicycleService {
    @Autowired
    private BicycleRepository bicycleRepository;

    @Override
    public Integer add(Bicycle bicycle) {
        this.bicycleRepository.save(bicycle);
        return bicycle.getId();
    }

    @Override
    public Integer add(String bicycleType, BigDecimal price, Integer inStock, String size, String manufacturer) {
        var bicycle = new Bicycle();
        bicycle.setBicycleType(bicycleType);
        bicycle.setPrice(price);
        bicycle.setInStock(inStock);
        bicycle.setSize(size.trim().equals("") ? null : size.trim());
        bicycle.setManufacturer(manufacturer.trim().equals("") ? null : manufacturer);
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
    public List<Bicycle> findByMaxPrice(Double maxPrice) {
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
