package com.boot.test.demo.model.dto;

import com.boot.test.demo.validation.FieldsValueMatch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "passwordRepeat",
        message = "Passwords do not match!"
)
public class UserRequestDto {
    @NotNull(message = "Login can't be null")
    private String login;
    @NotNull(message = "Password can't be null")
    @Size(min = 4, max = 16)
    private String password;
    private String passwordRepeat;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
