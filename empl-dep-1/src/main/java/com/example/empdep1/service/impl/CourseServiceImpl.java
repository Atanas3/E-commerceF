package com.example.empdep1.service.impl;

import com.example.empdep1.model.Course;
import com.example.empdep1.model.Student;
import com.example.empdep1.model.exception.CourseIsNotEmptyException;
import com.example.empdep1.model.exception.CourseNotFoundException;
import com.example.empdep1.repository.StudentRepository;
import com.example.empdep1.service.CourseService;
import com.example.empdep1.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course cour = this.findById(id);

        cour.setName(course.getName());
        return this.courseRepository.save(cour);
    }

    @Override
    public void deleteById(Long id) {
        Course course = findById(id);
        if(course.getStudents().size() > 0){
            throw new CourseIsNotEmptyException(id);
        }

        this.courseRepository.deleteById(id);
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Course course = this.findById(courseId);

        return null;
    }

    @Override
    public Course removeStudentFromCourse(String studentId, Long courseId) {
        return null;
    }

    @Override
    public Course findCourseByName(String name) {
            return this.courseRepository.findByName(name);
    }

    @Override
    public List<Course> findAllCoursesOlderThan(LocalDateTime localDateTime) {
        return this.courseRepository.findAllByCreateDateBefore(localDateTime);
    }
}
