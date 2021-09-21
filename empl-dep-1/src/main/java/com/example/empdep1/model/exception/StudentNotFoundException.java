package com.example.empdep1.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id){
        super(String.format("Student with id %s is not found", id));
    }
}
