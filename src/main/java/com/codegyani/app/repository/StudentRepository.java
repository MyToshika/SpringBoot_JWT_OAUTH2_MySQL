package com.codegyani.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegyani.app.model.entity.StudentInfo;



@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {

	StudentInfo findByEmail(String email);

}
