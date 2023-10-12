package ru.sfu.nivanova.lab6.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "roles", indexes = {
        @Index(name = "roles_role_uindex", columnList = "role", unique = true)
})
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", nullable = false)
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}