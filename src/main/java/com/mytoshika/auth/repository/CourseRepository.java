package com.mytoshika.auth.repository;





import org.springframework.data.jpa.repository.JpaRepository;


import com.mytoshika.auth.model.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	
	
}
