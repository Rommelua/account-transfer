package com.boot.test.demo.service.mapper;

import com.boot.test.demo.model.dto.UserResponseDto;
import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import com.boot.test.demo.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    private final AccountService accountService;

    public UserMapper(AccountService accountService) {
        this.accountService = accountService;
    }

    public UserResponseDto mapToDto(User user) {
        Account account = accountService.getByUser(user);
        String accountNumber = String.format("%08d", account.getId());
        return new UserResponseDto(user.getId(), user.getLogin(), accountNumber);
    }
}
