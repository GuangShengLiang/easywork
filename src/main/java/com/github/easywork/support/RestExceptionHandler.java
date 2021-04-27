package com.github.easywork.support;

import com.github.easywork.exception.BaseException;
import com.github.easywork.rest.RestCodeEnum;
import com.github.easywork.rest.RestResponse;
import com.github.easywork.rest.RestValidationResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice()
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestValidationResponse methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        RestValidationResponse response = new RestValidationResponse();
        ex.getBindingResult().getFieldErrors().forEach(e -> response.addValidationError(e.getField(), e.getRejectedValue(), e.getDefaultMessage()));
        return response;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestValidationResponse bindException(BindException ex) {
        RestValidationResponse response = new RestValidationResponse();
        ex.getBindingResult().getFieldErrors().forEach(e -> response.addValidationError(e.getField(), e.getRejectedValue(), e.getDefaultMessage()));
        return response;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String httpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return ex.getMessage();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String exceptionHandler(Exception ex) {
        log.error("server error ", ex);
        return "服务异常";
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity baseException(BaseException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(RestResponse.fail(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity servletRequestBindingException(ServletRequestBindingException ex) {
        if (ex.getMessage().indexOf("Missing request header 'uid'") >= 0) {
            return ResponseEntity.status(RestCodeEnum.未登录.code).body(RestResponse.fail(RestCodeEnum.未登录));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(RestResponse.fail(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler({ClientAbortException.class})
    public void ignore() {
    }
}
