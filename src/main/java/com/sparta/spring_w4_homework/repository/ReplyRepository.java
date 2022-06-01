package com.sparta.spring_w4_homework.repository;

import com.sparta.spring_w4_homework.model.Reply;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
