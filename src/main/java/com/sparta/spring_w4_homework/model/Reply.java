package com.sparta.spring_w4_homework.model;

import com.sparta.spring_w4_homework.utils.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reply extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String reply;
    private Long userid;
    private Long boardid;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public
}
