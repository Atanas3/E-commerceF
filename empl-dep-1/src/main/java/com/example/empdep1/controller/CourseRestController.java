package com.example.empdep1.controller;

import com.example.empdep1.model.Course;
import com.example.empdep1.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestController {
    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

    @PostMapping
    public Course save(Course course) {
        return this.courseService.save(course);
    }

    @PatchMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestParam Course course) {
        return this.courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        this.courseService.deleteById(id);
    }
}
