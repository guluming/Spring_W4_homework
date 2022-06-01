package com.sparta.spring_w4_homework.repository;

import com.sparta.spring_w4_homework.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
