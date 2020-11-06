package com.boot.test.demo.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TransferRequestDto {
    @NotNull(message = "id can't be null")
    private Long id;
    @Pattern(message = "amount must be valid number", regexp = "\\d+(\\.\\d\\d)?")
    private String amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
