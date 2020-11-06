package com.boot.test.demo.controller;

import com.boot.test.demo.model.dto.UserRequestDto;
import com.boot.test.demo.service.AuthenticationService;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRequestDto dto, BindingResult bindingResult,
                           Model model) {
        if (bindingResult.getAllErrors().size() > 0) {
            String massage = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            model.addAttribute("message", massage);
            return "/error";
        }
        service.register(dto.getLogin(), dto.getPassword());
        return "redirect:/login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "/unauthorized";
    }
}
