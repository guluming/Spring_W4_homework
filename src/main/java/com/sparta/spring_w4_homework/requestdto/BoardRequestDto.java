package com.sparta.spring_w4_homework.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String contentb;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
