package com.sparta.spring_w4_homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class BoardPageController {

    //로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    //회원가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    //상세 페이지
    @GetMapping("/board/view/{id}")
    public String boardview(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "view";
    }

    //수정 페이지
    @GetMapping("/board/edit/{id}")
    public String boardedit(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "edit";
    }
}
