package com.boot.test.demo.controller;

import com.boot.test.demo.model.dto.UserRequestDto;
import com.boot.test.demo.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String showAddPersonPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserRequestDto dto) {
        service.register(dto.getLogin(), dto.getPassword());
        return "redirect:/login";
    }
}
