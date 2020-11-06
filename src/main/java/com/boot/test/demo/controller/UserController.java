package com.boot.test.demo.controller;

import com.boot.test.demo.model.dto.UserResponseDto;
import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import com.boot.test.demo.service.AccountService;
import com.boot.test.demo.service.UserService;
import com.boot.test.demo.service.mapper.AccountMapper;
import com.boot.test.demo.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AccountService accountService;
    private final UserMapper userMapper;
    private final AccountMapper accountMapper;

    public UserController(UserService userService, AccountService accountService,
                          UserMapper userMapper, AccountMapper accountMapper) {
        this.userService = userService;
        this.accountService = accountService;
        this.userMapper = userMapper;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/cabinet")
    public String cabinet(Authentication authentication, Model model) {
        User user = userService.getByLogin(authentication.getName());
        Account account = accountService.getByUser(user);
        model.addAttribute("user", userMapper.mapToDto(user));
        model.addAttribute("account", accountMapper.mapToDto(account));
        List<UserResponseDto> allUsers = userService.getAll()
                .stream()
                .filter(u -> !u.getId().equals(user.getId()))
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
        model.addAttribute("allUsers", allUsers);
        return "/user/cabinet";
    }
}
