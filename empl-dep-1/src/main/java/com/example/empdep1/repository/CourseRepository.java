package com.example.empdep1.repository;

import com.example.empdep1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
    List<Course> findAllByCreateDateBefore(LocalDateTime localDateTime);
}
