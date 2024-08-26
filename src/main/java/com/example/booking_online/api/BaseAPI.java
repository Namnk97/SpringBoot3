package com.example.booking_online.api;

import com.example.booking_online.dto.response.ResponseData;
import com.example.booking_online.exception.LogicException;
import com.example.booking_online.locale.Translator;
import com.example.booking_online.util.DataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseAPI {

    public List<String> message = new ArrayList<>();
    public ResponseEntity<ResponseData> reportError(Object ex) {
        if (ex instanceof LogicException) {
            LogicException e = (LogicException) ex;
//            e.printStackTrace();
            log.error(Translator.toMessage(e.getErrorCode()), e);
            message.add(Translator.toMessage(e.getErrorCode()));
            return new ResponseEntity<>(ResponseData.ofFail(e), HttpStatus.OK);
        } else if (ex instanceof Exception) {
            Exception e = (Exception) ex;
//            e.printStackTrace();
            log.error(e.getMessage(), e);
            message.add(e.getMessage());
            return new ResponseEntity<>(ResponseData.ofFail(e.getMessage()), HttpStatus.OK);
        } else {
            message.add(Translator.toMessage(DataUtils.safeToString(ex)));
            log.error(Translator.toMessage(DataUtils.safeToString(ex)));
            return new ResponseEntity<>(ResponseData.ofFail("CM000"), HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseData> reportError(String code, String message) {
        return new ResponseEntity<>(ResponseData.ofFail(code, Translator.toMessage(message)), HttpStatus.OK);
    }
    public ResponseEntity<ResponseData> reportError() {
        return new ResponseEntity<>(ResponseData.ofFail("CM000"), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData> reportError(String code) {
        code = code == null ? "CM000" : code;
        return new ResponseEntity<>(ResponseData.ofFail(code, Translator.toMessage(code)), HttpStatus.OK);
    }
}
