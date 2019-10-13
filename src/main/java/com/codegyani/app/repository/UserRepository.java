package com.codegyani.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegyani.app.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
