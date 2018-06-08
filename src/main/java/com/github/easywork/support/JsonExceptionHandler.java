package com.github.easywork.support;

import com.github.easywork.exception.BaseException;
import com.github.easywork.json.JsonResponse;
import com.github.easywork.json.JsonValidationResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice()
@Slf4j
public class JsonExceptionHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return o instanceof JsonResponse ? o : JsonResponse.success(o);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonValidationResponse paramValidExceptionHandler(MethodArgumentNotValidException ex) {
        JsonValidationResponse response = new JsonValidationResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        ex.getBindingResult().getFieldErrors().forEach(e -> response.addValidationError(e.getField(), e.getRejectedValue(), e.getDefaultMessage()));
        return response;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponse bindException(BindException ex) {
        JsonValidationResponse response = new JsonValidationResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        ex.getBindingResult().getFieldErrors().forEach(e -> response.addValidationError(e.getField(), e.getRejectedValue(), e.getDefaultMessage()));
        return response;
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    protected JsonResponse baseException(BaseException ex) {
        return JsonResponse.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeNotAcceptableException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public JsonResponse mediaUnsupported(HttpMessageNotReadableException ex) {
        return JsonResponse.fail(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), ex.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public JsonResponse httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return JsonResponse.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JsonResponse exceptionHandler(Exception ex) {
        log.error("server error ", ex);
        return JsonResponse.fail("服务异常");
    }

    @ExceptionHandler({ClientAbortException.class})
    @ResponseBody
    public void ignore() {
    }
}
