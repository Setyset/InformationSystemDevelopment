package ru.sfu.nivanova.lab6.repository;

import ru.sfu.nivanova.lab6.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Integer> {
    List<Bicycle> findDistinctByPriceLessThan(Double price);
}
