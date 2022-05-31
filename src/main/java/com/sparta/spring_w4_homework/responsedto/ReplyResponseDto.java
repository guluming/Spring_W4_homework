package com.sparta.spring_w4_homework.responsedto;

import com.sparta.spring_w4_homework.model.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyResponseDto {

    private Long id;
    private String reply;
    private String username;
    private Long boardid;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ReplyResponseDto(Reply entity){
        this.id = entity.getId();
        this.reply = entity.getReply();
        this.username = entity.getUsername();
        this.boardid = entity.getBoardid();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
    }
}
