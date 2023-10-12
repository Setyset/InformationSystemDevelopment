package ru.sfu.nivanova.lab6.controller;

import ru.sfu.nivanova.lab6.form.BicycleForm;
import ru.sfu.nivanova.lab6.service.impl.BicycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class AddController {
    private final ApplicationContext context;
    private final BicycleServiceImpl bicycleService;

    @Autowired
    public AddController(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.bicycleService = context.getBean("bicycleServiceImpl", BicycleServiceImpl.class);
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("bicycleForm", new BicycleForm());
        return "add";
    }

    @PostMapping
    public String addByForm(@Valid BicycleForm bicycleForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        var id = bicycleService.add(
                bicycleForm.getType(),
                bicycleForm.getPrice(),
                bicycleForm.getInStock(),
                bicycleForm.getSize(),
                bicycleForm.getManufacturer());
        return "redirect:/find?id=" + id;
    }
}
