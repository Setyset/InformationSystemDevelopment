package ru.sfu.nivanova.lab6.controller;

import ru.sfu.nivanova.lab6.service.impl.BicycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    private final ApplicationContext context;
    private final BicycleServiceImpl apparelService;

    @Autowired
    public IndexController(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.apparelService = context.getBean("bicycleServiceImpl", BicycleServiceImpl.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("count", (long) apparelService.findAll().size());
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String privateHome() {
        return "private_page";
    }
}

