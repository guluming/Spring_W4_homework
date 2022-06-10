package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.JwtRequestDto;
import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import com.sparta.spring_w4_homework.responsedto.JwtResponseDto;
import com.sparta.spring_w4_homework.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //회원가입
    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody UserRequestDto params) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if(!username.equals("anonymousUser")){
            return "이미 로그인이 되어있습니다.";
        }
        return userService.signup(params);
    }

    //회원로그인
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtResponseDto login(@RequestBody JwtRequestDto params) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if(!username.equals("anonymousUser")){
            return new JwtResponseDto("이미 로그인이 되어있습니다.");
        }

        try {
            return userService.login(params);
        } catch (Exception e) {
            return new JwtResponseDto("닉네임 또는 패스워드를 확인해주세요");
        }
    }

    @GetMapping("/login/check")
    public boolean loginCheck(){
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(authentication);

        return authentication.equals("anonymousUser");
    }
}