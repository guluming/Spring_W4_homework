package com.sparta.spring_w4_homework.service;

import com.sparta.spring_w4_homework.model.Reply;
import com.sparta.spring_w4_homework.repository.ReplyRepository;
import com.sparta.spring_w4_homework.requestdto.ReplyRequestDto;
import com.sparta.spring_w4_homework.responsedto.ReplyResponseDto;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //댓글 저장
    @Transactional
    public String replysave(ReplyRequestDto params, String userid){
        if(params.getReply().equals("")){
            return "댓글 내용을 입력해주세요";
        }
        Reply reply = new Reply(params, userid);
        replyRepository.save(reply);
        return "댓글이 작성 되었습니다.";
    }

    //댓글 조회
    public List<ReplyResponseDto> replyfindAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "modifiedAt");
        List<Reply> list = replyRepository.findAll(sort);
        return list.stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }

    //댓글 수정
    @Transactional
    public String replyupdate(Long id, ReplyRequestDto params, String userid){
        Reply reply = replyRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 댓글 입니다."));
        if (!reply.getUserid().equals(userid)) {
            return "댓글 작성자가 아닙니다.";
        }

        if (params.getReply().equals("")) {
            return "댓글 내용을 입력해주세요";
        }
        reply.update(params.getReply());
        return "댓글이 수정 되었습니다.";
    }

    //댓글 삭제
    @Transactional
    public String replydelete(Long id, String userid){
        Reply reply = replyRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 댓글 입니다."));
        if (!reply.getUserid().equals(userid)) {
            return "댓글 작성자가 아닙니다.";
        }
        replyRepository.deleteById(id);
        return "댓글이 삭제 되었습니다.";
    }
}