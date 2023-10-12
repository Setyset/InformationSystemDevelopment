package ru.sfu.nivanova.lab6.controller;

import ru.sfu.nivanova.lab6.form.EditForm;
import ru.sfu.nivanova.lab6.form.IdForm;
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
@RequestMapping("/edit")
public class EditController {
    private final ApplicationContext context;
    private final BicycleServiceImpl bicycleService;

    @Autowired
    public EditController(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.bicycleService = context.getBean("bicycleServiceImpl", BicycleServiceImpl.class);
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("idForm", new IdForm());
        model.addAttribute("editForm", new EditForm());
        return "edit";
    }

    @GetMapping(params = "id")
    public String fillFormById(@Valid IdForm idForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editForm", new EditForm());
            return "edit";
        }
        if (bicycleService.findById(idForm.getId()) == null) {
            model.addAttribute("notFound", true);
            model.addAttribute("editForm", new EditForm());
            return "edit";
        }
        var form = new EditForm();
        form.setId(idForm.getId());
        var bicycle = bicycleService.findById(idForm.getId());
        form.setInStock(bicycle.getInStock());
        form.setPrice(bicycle.getPrice());
        model.addAttribute("editForm", form);
        return "edit";
    }

    @PostMapping
    public String editByForm(@Valid EditForm editForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        if (bicycleService.findById(editForm.getId()) == null) {
            model.addAttribute("notFound", true);
            return "edit";
        }
        bicycleService.update(editForm.getId(), editForm.getInStock(), editForm.getPrice());
        return "redirect:/find?id=" + editForm.getId();
    }
}
