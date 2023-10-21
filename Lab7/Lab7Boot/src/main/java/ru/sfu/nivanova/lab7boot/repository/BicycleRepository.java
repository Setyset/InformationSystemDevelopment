package ru.sfu.nivanova.lab7boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sfu.nivanova.lab7boot.entity.Bicycle;

import java.math.BigDecimal;
import java.util.List;

public interface BicycleRepository extends JpaRepository<Bicycle, Integer> {
    List<Bicycle> findDistinctByPriceLessThan(BigDecimal price);
}
