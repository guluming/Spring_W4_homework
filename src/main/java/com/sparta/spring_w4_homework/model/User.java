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
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Builder
    //public User(String username, String password, LocalDateTime createdAt, LocalDateTime modifiedAt){
    public User(String username, String password){
        this.username = username;
        this.password = password;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
    }
}
