package com.example.booking_online.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Builder
@Data
@NoArgsConstructor
@ToString
@Slf4j
@JsonInclude
public class LogicException extends Exception{
    private String errorCode;
    private String description;

//    public LogicException(String errorCode) {
//        if (null == errorCode || "".equals(errorCode)) {
//            errorCode= "CM000";
//        }
//        log.error(Translator.toMessage(errorCode));
//        this.errorCode = errorCode;
//        this.description = Translator.toMessage(errorCode);
//    }

    public LogicException(Exception ex) {
        ex.printStackTrace();
        if (ex instanceof LogicException) {
            this.errorCode = ((LogicException) ex).getErrorCode();
            this.description = ((LogicException) ex).getDescription();
        } else {
            this.errorCode = "CM000";
            this.description = ex.toString();
        }
        addSuppressed(ex);
    }
    public LogicException(String errorCode, String description) {
        log.error(errorCode, description);
        this.errorCode = errorCode;
        this.description = description;
    }

    public LogicException(String errorCode, Exception ex) {
        this.errorCode = errorCode;
        addSuppressed(ex);
    }

}
