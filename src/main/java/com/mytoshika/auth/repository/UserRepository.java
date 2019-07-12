package com.mytoshika.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytoshika.auth.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
