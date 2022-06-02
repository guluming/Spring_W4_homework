package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.service.LikeService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikeApiController {

    private final LikeService likeService;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //좋아요 하기
    @GetMapping("/like/save/{boardid}")
    public String like(@PathVariable Long boardid){
        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        return likeService.likelike(boardid, userid);
    }

    //좋아요 취소
    @GetMapping("/like/unlike/{boardid}")
    public String unlike(@PathVariable Long boardid){
        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        return likeService.likeunlike(boardid, userid);
    }
}
