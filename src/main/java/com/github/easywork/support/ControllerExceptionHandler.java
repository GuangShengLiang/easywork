package com.github.easywork.support;

import com.github.easywork.exception.BaseException;
import com.github.easywork.json.JsonResponse;
import com.github.easywork.json.JsonResponseCode;
import com.github.easywork.json.JsonValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice()
public class ControllerExceptionHandler {

    private Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonValidationResponse paramValidExceptionHandler(MethodArgumentNotValidException ex) {
        JsonValidationResponse response = new JsonValidationResponse();
        response.setCode(JsonResponseCode.参数错误.code);
        ex.getBindingResult().getFieldErrors().forEach(e -> response.addValidationError(e.getField(), e.getRejectedValue(), e.getDefaultMessage()));
        return response;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public JsonResponse paramValidExceptionHandler(HttpMessageNotReadableException ex) {
        return JsonResponse.failure(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected JsonResponse exceptionHandler(Exception ex) {
        log.error("server error ", ex);
        return JsonResponse.failure(JsonResponseCode.失败.code, ex.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    protected JsonResponse baseExceptionHandler(BaseException ex) {

        return JsonResponse.failure(ex.getErrors().getCode(), ex.getMessage());
    }
}
