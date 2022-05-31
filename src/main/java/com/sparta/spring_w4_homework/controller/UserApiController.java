package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.JwtRequestDto;
import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import com.sparta.spring_w4_homework.responsedto.JwtResponseDto;
import com.sparta.spring_w4_homework.security.UserDetailsImpl;
import com.sparta.spring_w4_homework.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService){
        this.userService = userService;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //중복 로그인 검사
//    @GetMapping("/api/usercheck")
//    public void usercheck(){
//
//    }

    //회원가입
//    @PostMapping("/user/signup")
//    public String signup(UserRequestDto params){
////        userService.signup(params);
////        return "redirect:/user/login";
//        return userService.signup(params);
//    }

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
}