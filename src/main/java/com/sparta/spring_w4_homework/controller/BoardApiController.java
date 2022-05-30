package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.BoardRequestDto;
import com.sparta.spring_w4_homework.responsedto.BoardResponseDto;
import com.sparta.spring_w4_homework.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardApiController {

    private final BoardService boardService;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //게시글 저장
    @PostMapping("/boards")
    public String save(@RequestBody BoardRequestDto params){
        return boardService.boardsave(params);
    }

    //게시글 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> findAll(){
        return boardService.boardfindAll();
    }

    //게시글 상세 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto findById(@PathVariable Long id){
        return boardService.boardfindById(id);
    }

    //게시글 수정
    @PatchMapping("/boards/{id}")
    public String update(@PathVariable Long id, @RequestBody BoardRequestDto params){
        return boardService.boardupdate(id, params);
    }

    //게시글 삭제
    @DeleteMapping("/boards/{id}")
    public String delete(@PathVariable Long id){
        return boardService.boarddelete(id);
    }
}