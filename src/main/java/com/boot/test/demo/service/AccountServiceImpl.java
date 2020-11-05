package com.boot.test.demo.service;

import com.boot.test.demo.exception.NotEnoughMoneyException;
import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import com.boot.test.demo.repository.AccountRepository;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public Account getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Account getByUser(User user) {
        return repository.findByUser(user);
    }

    @Transactional
    @Override
    public void moveMoney(Account from, Account to, BigDecimal amount) {
        if (from.getBalance().compareTo(amount) < 0) {
            throw new NotEnoughMoneyException(
                    "Not enough money to perform transfer on account " + from.getId());
        }
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));
        repository.save(from);
        repository.save(to);
    }
}
