package lab4.bicycle.controller;

import com.bicycle.model.RegisterForm;
import com.bicycle.model.Role;
import com.bicycle.model.User;
import com.bicycle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AuthController контроллер для аутентификации
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    /**
     * UserRepository для взаимодействия с users
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * PasswordEncoder для кодировки пароля
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Обработчик GET /login
     */
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    /**
     * Обработчик GET /register
     */
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    /**
     * Обработчик POST /register
     * @param registerForm RegisterForm экземпляр
     * @param model model экземлпяр
     * @return view
     */
    @PostMapping("/register")
    public String postRegister(RegisterForm registerForm, Model model) {

        var username = registerForm.getUsername();
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("infoFailure", String.format("User '%s' already exist", username));
            return "register";
        }

        try {
            userRepository.save(new User(
                    username,
                    passwordEncoder.encode(registerForm.getPassword()),
                    Role.USER
            ));
        } catch (DataAccessException e) {
            model.addAttribute("infoFailure", "DataAccessException");
            return "register";
        }
        return "login";
    }
}
