package ru.sfu.nivanova.lab6.controller;

import ru.sfu.nivanova.lab6.entity.Bicycle;
import ru.sfu.nivanova.lab6.form.IdForm;
import ru.sfu.nivanova.lab6.form.MaxPriceForm;
import ru.sfu.nivanova.lab6.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/find")
public class FindController {
    private final BicycleService bicycleService;

    @Autowired
    public FindController(@Qualifier("bicycleServiceImpl") BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping
    public String viewByIdOrAll(Model model) {
        model.addAttribute("idForm", new IdForm());
        model.addAttribute("maxPriceForm", new MaxPriceForm());

        var bicycles = bicycleService.findAll();
        model.addAttribute("bicycles", bicycles);
        return "find";
    }

    @GetMapping(params = "id")
    public String viewByIdOrAll(@Valid IdForm idForm, BindingResult bindingResultIdForm, MaxPriceForm maxPriceForm, Model model) {
        if (bindingResultIdForm.hasErrors()) {
            return "find";
        }
        if (idForm.getId() == 0) {
            return "redirect:/find";
        }
        List<Bicycle> bicycles = new ArrayList<>();
        var bicycle = bicycleService.findById(idForm.getId());
        if(bicycle != null) {
            bicycles.add(bicycleService.findById(idForm.getId()));
        }
        model.addAttribute("bicycles", bicycle);
        return "find";
    }

    @GetMapping(params = "price")
    public String viewByType(@Valid MaxPriceForm maxPriceForm, BindingResult bindingResultTypeForm, IdForm idForm, Model model) {
        if (bindingResultTypeForm.hasErrors()) {
            return "find";
        }
        var apparels = bicycleService.findByMaxPrice(maxPriceForm.getPrice());
        model.addAttribute("apparels", apparels);
        return "find";
    }
}
