package lab4.bicycle.repository;

import com.bicycle.model.Bicycle;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс BicycleRepository
 */
public interface BicycleRepository extends CrudRepository<Bicycle, Long> {

}
