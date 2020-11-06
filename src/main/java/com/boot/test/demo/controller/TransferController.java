package com.boot.test.demo.controller;

import com.boot.test.demo.model.dto.TransferRequestDto;
import com.boot.test.demo.model.entity.Account;
import com.boot.test.demo.model.entity.User;
import com.boot.test.demo.service.AccountService;
import com.boot.test.demo.service.UserService;
import java.math.BigDecimal;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    private final AccountService accountService;
    private final UserService userService;

    public TransferController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @PostMapping
    public String doTransfer(Authentication authentication, @Valid TransferRequestDto dto) {
        User user = userService.getByLogin(authentication.getName());
        Account from = accountService.getByUser(user);
        Account to = accountService.getById(dto.getId());
        BigDecimal amount = new BigDecimal(dto.getAmount());
        accountService.moveMoney(from, to, amount);
        return "redirect:/user/cabinet";
    }
}
