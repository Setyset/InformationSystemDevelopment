package lab4.bicycle;

import com.bicycle.model.Role;
import com.bicycle.model.User;
import com.bicycle.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Точка входа в программу spring boot
 */
@SpringBootApplication
public class fifthApplication {

    public static void main(String[] args) {
        SpringApplication.run(fifthApplication.class, args);
    }

    /**
     * CommandLineRine
     * Добавляет в базу админа если база пуста
     *
     * @param users UsersRepository
     * @return return
     */
    @Bean
    CommandLineRunner commandLineRunner(UserRepository users) {
        return args -> {
            if (users.findByUsername("admin").isEmpty()) {
                users.save(new User("admin", passwordEncoder().encode("admin"), Role.ADMIN));
            }
        };
    }

    /**
     * Password Encoder
     *
     * @return BCryptPasswordEncoder
     */
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
