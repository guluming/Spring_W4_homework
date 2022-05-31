package com.sparta.spring_w4_homework.requestdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String username;
    private String password;
    private String passwordchk;
}
