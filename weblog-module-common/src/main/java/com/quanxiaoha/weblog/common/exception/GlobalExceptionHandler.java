package com.quanxiaoha.weblog.common.exception;

import com.quanxiaoha.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: weblog-springboot
 * @description: 全局异常处理
 * @author: wangyoulang
 * @create: 2024-05-26 16:58
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BizException bizException) {
        log.warn("{} request fail, errorCode: {}, errorMessage: {}", request.getRequestURL(), bizException.getErrorCode(), bizException.getErrorMessage());
        return Response.fail(bizException);
    }
}
