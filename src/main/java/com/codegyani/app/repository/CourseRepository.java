package com.codegyani.app.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.codegyani.app.model.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	
	
}
