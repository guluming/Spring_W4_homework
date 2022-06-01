package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.BoardRequestDto;
import com.sparta.spring_w4_homework.responsedto.BoardResponseDto;
import com.sparta.spring_w4_homework.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //게시글 저장
    @PostMapping("/boards/save")
    public String save(@RequestBody BoardRequestDto params){

        String userid = SecurityContextHolder.getContext().getAuthentication().getName();

        return boardService.boardsave(params, userid);
    }

    //게시글 조회
    @GetMapping("/boards/list")
    public List<BoardResponseDto> findAll(){
        return boardService.boardfindAll();
    }

    //게시글 상세 조회
    @GetMapping("/boards/list/view/{id}")
    public BoardResponseDto findById(@PathVariable Long id){
        return boardService.boardfindById(id);
    }

    //게시글 수정
    @PatchMapping("/boards/edit/{id}")
    public String update(@PathVariable Long id, @RequestBody BoardRequestDto params){

        String userid = SecurityContextHolder.getContext().getAuthentication().getName();

        return boardService.boardupdate(id, params, userid);
    }

    //게시글 삭제
    @DeleteMapping("/boards/delete/{id}")
    public String delete(@PathVariable Long id){

        String userid = SecurityContextHolder.getContext().getAuthentication().getName();

        return boardService.boarddelete(id, userid);
    }
}