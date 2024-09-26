package com.example.booking_online.service.impl;

import com.example.booking_online.dto.AccountDTO;
import com.example.booking_online.entity.Account;
import com.example.booking_online.exception.LogicException;
import com.example.booking_online.repository.AccountRepository;
import com.example.booking_online.service.AccountService;
import com.example.booking_online.util.BaseMapperService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional(rollbackOn = {LogicException.class, Exception.class})
    public AccountDTO createAccount(AccountDTO dto) throws LogicException {
        Account account = accountRepository.save(Account
                .accountBuilder()
                .accountName(dto.getAccountName())
                .passwd(dto.getPasswd())
                .codeUser(dto.getCodeUser())
                .status(1L)
                .build());
        return BaseMapperService.map(account, AccountDTO.class);
    }
    //Check check1234
}
