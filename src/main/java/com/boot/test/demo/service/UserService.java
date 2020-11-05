package com.boot.test.demo.service;

import com.boot.test.demo.model.entity.User;

public interface UserService {
    User save(User user);

    User getById(Long id);

    User getByLogin(String login);
}
