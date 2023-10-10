package lab4.bicycle.security;

import com.bicycle.model.User;
import com.bicycle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UsersDetailsServiceImpl реализация интерфейса UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    private final UserRepository userRepository;

    /**
     * Конструктор UserDetailsServiceImpl
     * @param userRepository userRepository
     */
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Возвращает пользователя по имени
     * @param username имя
     * @return SecurityUser
     * @throws UsernameNotFoundException если пользователя нет
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist"));
        return SecurityUser.fromUserEntity(user);
    }
}
