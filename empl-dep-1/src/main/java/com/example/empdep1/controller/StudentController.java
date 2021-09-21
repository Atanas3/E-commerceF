package com.example.empdep1.controller;

import com.example.empdep1.model.Course;
import com.example.empdep1.model.Student;
import com.example.empdep1.service.CourseService;
import com.example.empdep1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    private CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String getStudentsPage(Model model) {
        List<Student> students = this.studentService.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/new")
    public String addNewStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "students";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        this.studentService.deleteById(id);
        return "redirect:/students";
    }

    @PostMapping
    public String saveStudent(Student student) throws IOException {
        try {
            this.studentService.save(student);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        return "redirect:/students";
    }

}
