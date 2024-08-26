package com.example.booking_online.dto.response;


import com.example.booking_online.constant.Constants;
import com.example.booking_online.exception.LogicException;
import com.example.booking_online.locale.Translator;
import com.example.booking_online.util.DataUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {
    private String message; //Constants.ERROR_CODE.
    private String errorCode; //Constants.ERROR_CODE.
    private String[] paramMessage; //Constants.ERROR_CODE.
    private Object payload;

    public ResponseData() {
    }

    public ResponseData(String errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseData(String errorCode, Object data) {
        this.errorCode = errorCode;
        this.message = Translator.toMessage(errorCode);
        this.payload = data;
    }

    public static ResponseData ofSuccess() {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(Constants.ERROR_CODE.SUCCESS);
        return responseData;
    }

    public static ResponseData ofSuccess(Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(Constants.ERROR_CODE.SUCCESS);
        responseData.setPayload(data);
        return responseData;
    }

    public static ResponseData ofSuccess(String errorCode, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode);
        responseData.setPayload(data);
        responseData.setMessage(Translator.toMessage(errorCode));
        return responseData;
    }

    public static ResponseData ofFail(String errorCode) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode);
        responseData.setMessage(Translator.toMessage(errorCode));
        return responseData;
    }
    public static ResponseData ofFail(LogicException errorCode) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode.getErrorCode());
        if ("CM000".equals(errorCode.getErrorCode())) {
            responseData.setMessage(DataUtils.safeToString(errorCode.getDescription(),
                    Translator.toMessage(errorCode.getErrorCode())));
        } else {
            responseData.setMessage(Translator.toMessage(errorCode.getErrorCode()));
        }
        return responseData;
    }

    public static ResponseData ofFail(String setErrorCode, String message) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(setErrorCode);
        responseData.setMessage(Translator.toMessage(message));
        return responseData;
    }

    public static ResponseData ofFail(String errorCode, String... paramMessage) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode);
        responseData.setMessage(Translator.toMessage(errorCode, paramMessage));
        responseData.setParamMessage(paramMessage);
        return responseData;
    }

    public static ResponseData ofFail(String errorCode, List<String> paramMessage) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode);
        responseData.setMessage(Translator.toMessage(errorCode, paramMessage.toArray()));
        if (paramMessage != null && paramMessage.size() > 0)
            responseData.setParamMessage((String[]) paramMessage.stream().toArray());
        return responseData;
    }

    public static ResponseData ofFail(List<String> errorCode, String... paramMessage) {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode.get(0));
        responseData.setMessage(Translator.toMessage(errorCode.get(0), paramMessage));
        responseData.setParamMessage(paramMessage);
        return responseData;
    }


    @Override
    public String toString() {
        return "ResponseData{" +
                "errorCode='" + errorCode + '\'' +
                ", paramMessage=" + Arrays.toString(paramMessage) +
                ", payload=" + payload +
                ", message=" + message +
                '}';
    }

}
