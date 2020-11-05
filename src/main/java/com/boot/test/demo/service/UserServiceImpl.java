package com.boot.test.demo.service;

import com.boot.test.demo.model.entity.User;
import com.boot.test.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }
}
