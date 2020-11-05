package com.boot.test.demo.service;

import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final AccountService accountService;

    @Value("${balance.default}")
    private String defaultBalanceVal;

    public AuthenticationServiceImpl(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Transactional
    @Override
    public User register(String login, String password) {
        User user = new User(login, password);
        user = userService.save(user);
        BigDecimal defaultBalance = new BigDecimal(defaultBalanceVal);
        Account account = new Account(defaultBalance, user);
        accountService.save(account);
        return user;
    }
}
