package com.boot.test.demo.service;

import com.boot.test.demo.model.entity.User;

public interface AuthenticationService {
    User register(String email, String password);
}
