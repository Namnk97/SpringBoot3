package com.example.booking_online.service;

import com.example.booking_online.dto.AccountDTO;
import com.example.booking_online.exception.LogicException;

public interface AccountService {
 AccountDTO createAccount(AccountDTO dto) throws LogicException;




}
