package com.sparta.spring_w4_homework.requestdto;

import com.sparta.spring_w4_homework.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String username;
    private String password;
    private String passwordchk;

//    public User toEntity(){
//        return User.builder()
//                .username(username)
//                .password(password)
//                .build();
//    }
}
