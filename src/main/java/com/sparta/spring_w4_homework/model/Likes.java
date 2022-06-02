package com.sparta.spring_w4_homework.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Likes {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private Long boardid;
    @Column(nullable = false)
    private String userid;

    public Likes(Long boardid, String userid){
        this.boardid = boardid;
        this.userid = userid;
    }
}
