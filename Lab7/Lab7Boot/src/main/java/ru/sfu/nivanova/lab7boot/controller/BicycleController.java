package ru.sfu.nivanova.lab7boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sfu.nivanova.lab7boot.dto.EditBicycleDTO;
import ru.sfu.nivanova.lab7boot.entity.Bicycle;
import ru.sfu.nivanova.lab7boot.service.BicycleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("bicycle")
public class BicycleController {
    private final BicycleService bicycleService;

    @GetMapping(value = "/", headers = {"Accept=application/json"})
    public List<Bicycle> getBicycles() {
        return bicycleService.findAll();
    }

    @GetMapping("/{id}")
    public Bicycle getBicycleById(@PathVariable Integer id) {
        return bicycleService.findById(id);
    }

    @PostMapping("/")
    public Integer createBicycle(@RequestBody Bicycle bicycle) {
        return bicycleService.add(bicycle);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBicycleById(@PathVariable Integer id){
        return bicycleService.delete(id);
    }

    @PostMapping("/{id}")
    public Bicycle patchBicycleById(@PathVariable Integer id, @RequestBody EditBicycleDTO dto) {
        return bicycleService.patch(id, dto);
    }
}
