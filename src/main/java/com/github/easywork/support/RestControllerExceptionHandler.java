package com.github.easywork.support;

import com.github.easywork.exception.BaseException;
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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice()
@Slf4j
public class RestControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestValidationResponse paramValidExceptionHandler(MethodArgumentNotValidException ex) {
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

   /* @ExceptionHandler(ServletException.class)
    public void paramValidExceptionHandler(ServletException ex) {
    }*/

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public String paramValidExceptionHandler(HttpMessageNotReadableException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public String httpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return ex.getMessage();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandler(Exception ex) {
        log.error("server error ", ex);
        return "服务异常";
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity baseExceptionHandler(BaseException ex) {

        return ResponseEntity.status(ex.getErrors().getCode()).body(ex.getErrors().getMessage());
    }

    @ExceptionHandler({ClientAbortException.class})
    public void ignore() {
    }
}
