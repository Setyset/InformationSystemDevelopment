package lab4.bicycle.model;

import jakarta.persistence.*;

/**
 * Сущность User
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    /**
     * Конструктор User
     */
    public User() {
    }

    /**
     * Конструктор User
     *
     * @param username имя
     * @param password пароль
     * @param role     роль
     */
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Getter id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter role
     *
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter role
     *
     * @param role role
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
