package lab4.bicycle.repository;

import com.bicycle.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Интерфейс UserRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
