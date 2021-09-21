package com.example.empdep1.service.impl;

import com.example.empdep1.model.Student;
import com.example.empdep1.model.exception.StudentNotFoundException;
import com.example.empdep1.repository.StudentRepository;
import com.example.empdep1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

    }

    @Override
    public void deleteById(Long id){
        this.studentRepository.deleteById(id);
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
