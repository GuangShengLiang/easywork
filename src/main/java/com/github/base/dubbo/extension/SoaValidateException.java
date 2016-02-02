package com.github.base.dubbo.extension;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.github.base.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @Author lgs
 * @Date 15-12-16 上午11:41
 */
@Slf4j
public class SoaValidateException extends BaseException implements ExceptionMapper<RpcException> {
    public Response toResponse(RpcException e) {
        System.out.println("Exception mapper successfully got an exception: " + e + ":" + e.getMessage());
        System.out.println("Client IP is " + RpcContext.getContext().getRemoteAddressString());
        log.error("SoaValidateException",e);
        throw new SoaValidateException();
    }
}
