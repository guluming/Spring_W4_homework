package com.sparta.spring_w4_homework.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CustomeBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=utf-8");
        response.addHeader("WWW-Authenticate", "Basic realm=" + super.getRealmName());

        PrintWriter writer = response.getWriter();

//        writer.println("HTTP Status 401 - " + authException.getMessage());
        writer.println("로그인이 필요합니다.");
    }

    @Override
    public void afterPropertiesSet() {
        super.setRealmName("pilseong");
        super.afterPropertiesSet();
    }
}