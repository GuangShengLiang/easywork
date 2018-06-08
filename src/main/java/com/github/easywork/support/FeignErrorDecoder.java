package com.github.easywork.support;


import com.github.easywork.exception.BaseException;
import com.github.easywork.rest.RestResponse;
import com.google.gson.Gson;
import feign.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class FeignErrorDecoder implements feign.codec.ErrorDecoder{
    @Override
    public Exception decode(String methodKey, Response response) {
        RestResponse rst = null;
        try {
            rst = new Gson().fromJson(response.body().asReader(), RestResponse.class);
        } catch (IOException e) {
            log.error("BizExceptionFeignErrorDecoder.decode", e);
            return new BaseException();
        }
        return new BaseException(rst.getCode(),rst.getMsg());
    }
}
