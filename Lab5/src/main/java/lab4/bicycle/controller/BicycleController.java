package lab4.bicycle.controller;

import com.bicycle.model.Bicycle;
import com.bicycle.model.CreateForm;
import com.bicycle.model.EditForm;
import com.bicycle.repository.BicycleRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер /api/bicycles
 */
@Controller
@RequestMapping("/api/bicycles")
public class BicycleController {

    /**
     * BikeRepository для взаимодействия с данными bicycles
     */
    private final BicycleRepository bicycles;

    /**
     * Конструктор BicycleController
     *
     * @param bicycles BicycleRepository instance
     */
    public BicycleController(BicycleRepository bicycles) {
        this.bicycles = bicycles;
    }

    /**
     * Обработчик GET /api/bicycles
     */
    @GetMapping
    public Iterable<Bicycle> getAll() {
        return bicycles.findAll();
    }

    /**
     * Обработчик POST /api/bicycles
     *
     * @param createForm CreateForm экземпляр
     * @param model      Model экземпляр
     * @return view
     */
    @PostMapping
    public String create(CreateForm createForm, Model model) {
        try {
            bicycles.save(Bicycle.fromForm(createForm));
        } catch (DataAccessException e) {
            model.addAttribute("infoFailure", "DataAccessException");
            return "response";
        }
        model.addAttribute("description", "Success!");
        return "response";
    }

    /**
     * Обработчик POST /api/bicycles/delete
     *
     * @param bicycle Bicycle экземпляр
     * @param model   Model экземпляр
     * @return view
     */
    @PostMapping("/delete")
    public String deleteById(@ModelAttribute Bicycle bicycle, Model model) {
        var id = bicycle.getId();
        if (id < 1) {
            model.addAttribute("description", "Incorrect ID");
            return "response";
        }

        try {
            bicycles.deleteById(id);
        } catch (DataAccessException e) {
            model.addAttribute("description", "DataAccessException");
            return "response";
        }

        model.addAttribute("description", "Success!");
        return "response";
    }

    /**
     * Обработчик POST /api/bicycles/edit
     *
     * @param editForm EditForm экземпляр
     * @param model    Model экземпляр
     * @return view
     */
    @PostMapping("/edit")
    public String updateById(EditForm editForm, Model model) {
        Bicycle bicycle;
        try {
            bicycle = Bicycle.fromForm(editForm);
        } catch (DataAccessException e) {
            model.addAttribute("description", "DataAccessException");
            return "response";
        }

        if (bicycles.findById(bicycle.getId()).isEmpty()) {
            model.addAttribute("description", "There is no bicycle with this id");
            return "response";
        }

        try {
            bicycles.save(bicycle);
        } catch (DataAccessException e) {
            model.addAttribute("description", "failed to save");
            return "response";
        }

        model.addAttribute("description", "Success!");
        return "response";
    }
}