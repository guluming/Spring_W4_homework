package com.sparta.spring_w4_homework.model;

import com.sparta.spring_w4_homework.requestdto.ReplyRequestDto;
import com.sparta.spring_w4_homework.utils.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reply extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String reply;
    @Column(nullable = false)
    private Long boardid;
    @Column(nullable = false)
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public Reply(String reply, Long boardid, String username){
        this.reply = reply;
        this.boardid = boardid;
        this.username = username;
    }

    public Reply(ReplyRequestDto params){
        this.username = params.getUsername();
        this.reply = params.getReply();
        this.boardid = params.getBoardid();
    }

    public void update(String reply){
        this.reply = reply;
        this.modifiedAt = LocalDateTime.now();
    }
}
