package lab4.bicycle.security;

import com.bicycle.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Имплементация интерфейса UserDetails (кастомный)
 */
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;


    /**
     * Конструктор Security user
     *
     * @param username    username
     * @param password    password
     * @param authorities authorities
     */
    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Getter authorities
     *
     * @return authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Getter password
     *
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Getter username
     *
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Getter isAccountNonExpired
     *
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Getter isAccountNonLocker
     *
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Getter isCredentialsNonExpired
     *
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Getter isEnabled
     *
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Создание пользователя для Spring из сущности User
     *
     * @param user user
     * @return User пользователь спринг
     */
    public static UserDetails fromUserEntity(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                true, true, true, true,
                user.getRole().getAuthorities());
    }
}
