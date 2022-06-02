package com.sparta.spring_w4_homework.repository;

import com.sparta.spring_w4_homework.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUseridAndBoardid(String userid, Long boardId);
}
