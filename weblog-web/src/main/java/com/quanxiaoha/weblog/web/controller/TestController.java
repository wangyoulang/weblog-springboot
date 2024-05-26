package com.quanxiaoha.weblog.web.controller;

import com.quanxiaoha.weblog.common.enums.ResponseCodeEnum;
import com.quanxiaoha.weblog.common.exception.BizException;
import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.web.model.User;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * @author: 犬小哈
 * @url: www.quanxiaoha.com
 * @date: 2023-08-10 10:34
 * @description: TODO
 **/
@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public ResponseEntity<String> test(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 获取校验不通过字段的提示信息
            String errorMsg = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errorMsg);
        }
        return ResponseEntity.ok("参数没有任何问题");
    }

    /**
     * postman入参：
     * {
     *     "username": "",
     *     "sex": null,
     *     "age": 120,
     *     "email": "123124"
     * }
     * @param user
     * @return
     */
    @PostMapping("/test1")
    @ApiOperationLog
    public Response test1(@RequestBody @Valid User user) {
        return Response.success();
    }

    @PostMapping("/test2")
    @ApiOperationLog
    public Response test2(@RequestBody @Valid User user, BindingResult bindingResult) {
//        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND.getErrorCode(), ResponseCodeEnum.PRODUCT_NOT_FOUND.getErrorMessage());
        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
    }

}
