package com.sparta.spring_w4_homework.requestdto;

import com.sparta.spring_w4_homework.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String username;
    private String password;
    private String passwordchk;
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime modifiedAt;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
//                .createdAt(createdAt)
//                .modifiedAt(modifiedAt)
                .build();
    }
}
