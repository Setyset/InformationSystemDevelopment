package lab4.bicycle.config;

import com.bicycle.model.Permission;
import com.bicycle.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * SecurityConfig класс
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Реализация класса UserDetailsServiceImpl
     */
    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Конструктор для UserDetailsServiceImpl
     *
     * @param userDetailsService userDetailsService экземпляр
     */
    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * SecurityFilterChain для установки прав доступа
     * и установки login и logout
     *
     * @param http HttpSecurity экземлпяр
     * @return http билд
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/create").hasAuthority(Permission.BICYCLES_WRITE.getPermission())
                        .requestMatchers("/edit").hasAuthority(Permission.BICYCLES_WRITE.getPermission())
                        .requestMatchers("/delete").hasAuthority(Permission.BICYCLES_WRITE.getPermission())
                        .requestMatchers("/list").hasAuthority(Permission.BICYCLES_READ.getPermission())
                        .requestMatchers("/find").hasAuthority(Permission.BICYCLES_READ.getPermission())
                        .requestMatchers(HttpMethod.GET, "/api/**").hasAuthority(Permission.BICYCLES_READ.getPermission())
                        .requestMatchers(HttpMethod.POST, "/api/**").hasAuthority(Permission.BICYCLES_WRITE.getPermission())
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Permission.BICYCLES_WRITE.getPermission())
                        .requestMatchers(HttpMethod.PUT, "/api/**").hasAuthority(Permission.BICYCLES_WRITE.getPermission())
                )
                .userDetailsService(userDetailsService)
                .formLogin((form) -> form
                        .loginPage("/auth/login").permitAll()
                        .defaultSuccessUrl("/menu")
                )
                .logout((logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/auth/login")
                        .permitAll()
                ));

        return http.build();
    }

    /**
     * Возвращает экщемпляр BCryptPasswordEncoder для кодировки пароля
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


}
