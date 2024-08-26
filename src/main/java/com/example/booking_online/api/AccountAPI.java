package com.example.booking_online.api;


import com.example.booking_online.dto.AccountDTO;
import com.example.booking_online.dto.response.ResponseData;
import com.example.booking_online.exception.LogicException;
import com.example.booking_online.service.AccountService;
import com.example.booking_online.util.PreventDuplicateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/account")
public class AccountAPI extends BaseAPI{

    @Autowired
    private AccountService accountService;

    @PostMapping (value = "/add")
    @PreventDuplicateRequest
    public ResponseEntity<ResponseData> addAccount(@RequestBody AccountDTO dto) {
        try {
            accountService.createAccount(dto);
            return new ResponseEntity<>(ResponseData.ofSuccess(), HttpStatus.OK);
        } catch (LogicException e) {
            return reportError(e);
        } catch (Exception ex) {
            log.info(String.valueOf(ex));
            return reportError("CM000");
        }
    }

}
