package com.sparta.spring_w4_homework.service;

import com.sparta.spring_w4_homework.model.Board;
import com.sparta.spring_w4_homework.model.Likes;
import com.sparta.spring_w4_homework.repository.BoardRepository;
import com.sparta.spring_w4_homework.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final BoardRepository boardRepository;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //좋아요 하기
    public String likelike(Long boardId, String userid){
        Likes likeChk = likeRepository.findByUseridAndBoardid(userid, boardId).orElse(null);
        if(likeChk != null){
            return "이미 좋아요를 했습니다.";
        }
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("0"));
        board.likeupdate();
        Likes likeUp = new Likes(boardId, userid);
        likeRepository.save(likeUp);
        return "좋아요가 추가 되었습니다.";
    }

    //좋아요 취소
    public String likeunlike(Long boardId, String userid){
        Likes likeChk = likeRepository.findByUseridAndBoardid(userid, boardId).orElse(null);
        if(likeChk != null){
            Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("0"));
            board.unlikeupdate();
            likeRepository.delete(likeRepository.findByUseridAndBoardid(userid, boardId).orElseThrow(() -> new NullPointerException("좋아요를 하지 않았습니다.")));
            return "좋아요가 취소 되었습니다.";
        }
        return "좋아요를 한 적이 없습니다.";
    }
}
