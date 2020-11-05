package com.boot.test.demo.repository;

import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUser(User user);
}
