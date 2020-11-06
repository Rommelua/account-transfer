package com.boot.test.demo.service;

import com.boot.test.demo.model.entity.User;
import java.util.List;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User getByLogin(String login);
}
