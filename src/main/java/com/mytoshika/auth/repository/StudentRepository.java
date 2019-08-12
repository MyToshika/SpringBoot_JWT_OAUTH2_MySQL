package com.mytoshika.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytoshika.auth.model.entity.StudentInfo;



@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {

	StudentInfo findByEmail(String email);

}
