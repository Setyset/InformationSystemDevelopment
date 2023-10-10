package lab4.bicycle.controller;

import com.bicycle.model.Bicycle;
import com.bicycle.model.CreateForm;
import com.bicycle.model.EditForm;
import com.bicycle.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * Основной контроллер
 */
@Controller
public class MainController {


    /**
     * BikeRepository для работы с данными bicycles
     */
    @Autowired
    private BicycleRepository bicycleRepository;

    /**
     * Обработчик для GET /
     *
     * @return view
     */
    @GetMapping("/")
    public String getMain() {
        return "menu";
    }

    /**
     * Обработчик для GET /menu
     *
     * @return view
     */
    @GetMapping("/menu")
    public String getMenu() {
        return "menu";
    }

    /**
     * Обработчик для GET /bicycles
     *
     * @return view
     */
    @GetMapping("/bicycles")
    public String getBicycles(Model model) {
        var bicycles = new ArrayList<Bicycle>();
        bicycleRepository.findAll().forEach(bicycles::add);
        model.addAttribute("bicycles", bicycles);
        return "bicycles";
    }

    /**
     * Обработчик для GET /create
     *
     * @return view
     */
    @GetMapping("/create")
    public String getCreate(CreateForm createForm) {
        return "create";
    }

    /**
     * Обработчик для GET /delete
     *
     * @return view
     */
    @GetMapping("/delete")
    public String getDelete(Bicycle bicycle, Model model) {
        model.addAttribute("bicycle", new Bicycle());
        return "delete";
    }

    /**
     * Обработчик для GET /edit
     *
     * @return view
     */
    @GetMapping("/edit")
    public String getEdit(EditForm editForm) {

        return "edit";
    }
}
