package com.boot.test.demo.service;

import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import java.math.BigDecimal;

public interface AccountService {
    Account save(Account account);

    Account getById(Long id);

    Account getByUser(User user);

    void moveMoney(Account from, Account to, BigDecimal amount);
}
