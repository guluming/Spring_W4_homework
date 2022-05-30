package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import com.sparta.spring_w4_homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService){
        this.userService = userService;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //회원가입
    @PostMapping("/user/signup")
    public String signup(@RequestBody UserRequestDto params){
        //userService.signup(params);
        return userService.signup(params);
    }

//    //회원로그인
//    @PostMapping("/user/login")
//    public String iogin(Long id, @RequestBody MemberRequestDto params){
//        return memberService.memberlogin(id, params);
//    }
}