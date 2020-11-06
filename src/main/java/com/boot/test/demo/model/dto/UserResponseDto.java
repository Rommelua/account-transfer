package com.boot.test.demo.model.dto;

public class UserResponseDto {
    private Long id;
    private String login;
    private String accountNumber;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String login, String accountNumber) {
        this.id = id;
        this.login = login;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
