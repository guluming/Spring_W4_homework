package com.sparta.spring_w4_homework.model;

import com.sparta.spring_w4_homework.utils.Timestamped;
import lombok.Builder;
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
    private String memberid;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Builder
    public Board(String title, String contentb, String memberid, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.contentb = contentb;
        this.memberid = memberid;
        this.createdAt = createAt;
        this.modifiedAt = modifiedAt;
    }

    public void update(String title, String contentb){
        this.title = title;
        this.contentb = contentb;
        this.modifiedAt = LocalDateTime.now();
//        this.modifiedDate = LocalDateTime.now();
    }
}