package com.quanxiaoha.weblog.common.exception;

import com.quanxiaoha.weblog.common.enums.ResponseCodeEnum;
import com.quanxiaoha.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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

    /**
     * 捕获参数校验异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String errorCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();
        StringBuilder sb = new StringBuilder();
        // 获取校验不通过的字段，并组合错误信息，格式为：email 邮箱格式不正确，当前值：‘123456qq.com’;
        Optional.ofNullable(bindingResult.getFieldErrors()).ifPresent(errors ->{
            errors.forEach(error ->
                    sb.append(error.getField())
                            .append(" ")
                            .append(error.getDefaultMessage())
                            .append(", 当前值：")
                            .append(error.getRejectedValue())
                            .append(";")
            );
        });
        String errorMessage = sb.toString();
        log.warn("{} request fail, errorCode: {}, errorMessage: {}", request.getRequestURL(), errorCode, errorMessage);
        return Response.fail(errorCode, errorMessage);

    }

}
