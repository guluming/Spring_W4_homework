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
    @Column(nullable = false)
    private Long userid;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public Board(BoardRequestDto params) {
        this.userid = params.getUserid();
        this.title = params.getTitle();
        this.contentb = params.getContentb();
    }

    public void update(String title, String contentb){
        this.title = title;
        this.contentb = contentb;
        this.modifiedAt = LocalDateTime.now();
    }
}