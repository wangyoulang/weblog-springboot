package com.quanxiaoha.weblog.jwt.handler;

import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.jwt.model.LoginRspVO;
import com.quanxiaoha.weblog.jwt.utils.JwtTokenHelper;
import com.quanxiaoha.weblog.jwt.utils.ResultUtils;
import io.jsonwebtoken.JwtParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: weblog-springboot
 * @description: 认证成功处理器RestAuthenticationSuccessHandler
 * @author: wangyoulang
 * @create: 2024-06-09 17:11
 **/
@Component
@Slf4j
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 通过JwtTokenHelper生成Token
        String username = userDetails.getUsername();
        String token = jwtTokenHelper.generateToken(username);

        // 返回token
        LoginRspVO loginRspVO = LoginRspVO.builder().token(token).build();
        ResultUtils.ok(response, Response.success(loginRspVO));
    }
}
