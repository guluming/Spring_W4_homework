package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.UserRequestDto;
import com.sparta.spring_w4_homework.security.UserDetailsImpl;
import com.sparta.spring_w4_homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BoardPageController {

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
}
