package com.boot.test.demo.service.mapper;

import com.boot.test.demo.model.dto.AccountResponseDto;
import com.boot.test.demo.model.entity.Account;
import java.text.DecimalFormat;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    public AccountResponseDto mapToDto(Account account) {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(true);
        String amount = df.format(account.getBalance());
        return new AccountResponseDto(account.getId(), amount, account.getUser().getId());
    }
}
