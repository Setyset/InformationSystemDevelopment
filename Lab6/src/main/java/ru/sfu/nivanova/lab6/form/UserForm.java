package ru.sfu.nivanova.lab6.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserForm {
    @NotBlank(message = "Can't be blank")
    @Length(min = 6, max = 20)
    private String username;

    @NotBlank(message = "Can't be blank")
    @Length(min = 6, max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
