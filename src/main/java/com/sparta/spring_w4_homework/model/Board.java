package com.sparta.spring_w4_homework.model;

import com.sparta.spring_w4_homework.requestdto.BoardRequestDto;
import com.sparta.spring_w4_homework.utils.Timestamped;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contentb;
    private Long boardlikes = 0L;
    @Column(nullable = false)
    private String userid;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public Board(BoardRequestDto params, String userid) {
        this.title = params.getTitle();
        this.contentb = params.getContentb();
        this.userid = userid;
    }

    public void update(BoardRequestDto params){
        this.title = params.getTitle();
        this.contentb = params.getContentb();
        this.modifiedAt = LocalDateTime.now();
    }

    public void likeupdate(){
        this.boardlikes++;
    }

    public void unlikeupdate(){
        this.boardlikes--;
    }
}