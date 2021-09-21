package com.example.empdep1.model.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(Long id){
        super(String.format("Course with id %s is not found", id));
    }
}

