package com.sparta.spring_w4_homework.requestdto;

import com.sparta.spring_w4_homework.model.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String contentb;
    private String memberid;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contentb(contentb)
                .memberid(memberid)
                .createAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
