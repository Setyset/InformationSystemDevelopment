package lab4.bicycle.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enum ролей
 */
public enum Role {
    USER(Set.of(Permission.BICYCLES_READ)),
    ADMIN(Set.of(Permission.BICYCLES_READ, Permission.BICYCLES_WRITE));

    private final Set<Permission> permissions;

    /**
     * Конструктор Role
     *
     * @param permissions permissions для роли
     */
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * Getter permissions
     *
     * @return Set<Permission>
     */
    public Set<Permission> getPermissions() {
        return permissions;
    }

    /**
     * Getter authorities
     *
     * @return authorities
     */
    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
