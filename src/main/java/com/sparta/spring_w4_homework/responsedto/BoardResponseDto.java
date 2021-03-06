package com.sparta.spring_w4_homework.responsedto;

import com.sparta.spring_w4_homework.model.Board;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String contentb;
    private String userid;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long boardlikes;

    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contentb = entity.getContentb();
        this.userid = entity.getUserid();
        this.createdAt =entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
        this.boardlikes = entity.getBoardlikes();
    }
}
