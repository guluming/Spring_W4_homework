package com.sparta.spring_w4_homework.repository;

import com.sparta.spring_w4_homework.model.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {}