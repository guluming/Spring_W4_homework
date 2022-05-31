package com.sparta.spring_w4_homework.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

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

    @GetMapping("/dashboard")
    public String dashboard() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("=========================");
        System.out.println(username);
        System.out.println("=========================");
        return "dashboard";
    }
}