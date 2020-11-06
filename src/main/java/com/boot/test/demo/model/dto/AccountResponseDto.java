package com.boot.test.demo.model.dto;

public class AccountResponseDto {
    private Long id;
    private String balance;
    private Long userId;

    public AccountResponseDto() {
    }

    public AccountResponseDto(Long id, String balance, Long userId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
