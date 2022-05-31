package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
//@Controller
public class HomeController {

//    private final UserService userService;

//    @Autowired
//    public BoardPageController(UserService userService) {
//        this.userService = userService;
//    }

    //메인 화면
//    @GetMapping("/")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        model.addAttribute("username", userDetails.getUsername());
//        return "index";
//    }

    //로그인 페이지
//    @GetMapping("/user/loginView")
//    public String login() {
//        return "login";
//    }

    //회원가입 페이지
//    @GetMapping("/user/signup")
//    public String signup() {
//        return "signup";
//    }

    //회원가입
//    @PostMapping("/user/signup")
//    public String signup(UserRequestDto params){
//        userService.signup(params);
//        return "redirect:/user/login";
////        return userService.signup(params);
//    }

//    //상세 페이지
//    @GetMapping("/board/view/{id}")
//    public String boardview(@PathVariable Long id, Model model) {
//        model.addAttribute("id", id);
//        return "view";
//    }
//
//    //수정 페이지
//    @GetMapping("/board/edit/{id}")
//    public String boardedit(@PathVariable Long id, Model model) {
//        model.addAttribute("id", id);
//        return "edit";
//    }

//    @GetMapping("/dashboard")
//    public String dashboard() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        System.out.println("=========================");
//        System.out.println(username);
//        System.out.println("=========================");
//        return "dashboard";
//    }
}