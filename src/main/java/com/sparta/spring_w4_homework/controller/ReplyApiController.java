package com.sparta.spring_w4_homework.controller;

import com.sparta.spring_w4_homework.requestdto.ReplyRequestDto;
import com.sparta.spring_w4_homework.responsedto.ReplyResponseDto;
import com.sparta.spring_w4_homework.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    private final ReplyService replyService;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //댓글 저장
    @PostMapping("/replys/save")
    public String save(@RequestBody ReplyRequestDto params){
        return replyService.replysave(params);
    }

    //댓글 조회
    @GetMapping("/replys/list")
    public List<ReplyResponseDto> findAll(){
        return replyService.replyfindAll();
    }

    //댓글 수정
    @PatchMapping("/replys/edit/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody ReplyRequestDto params){
        return replyService.replyupdate(id, params);
    }

    //댓글 삭제
    @DeleteMapping("replys/delete/{id}")
    public String delete(@PathVariable Long id
                        ){
        return replyService.replydelete(id);
    }

}
