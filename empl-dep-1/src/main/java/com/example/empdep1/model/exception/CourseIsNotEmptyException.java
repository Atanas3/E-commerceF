package com.example.empdep1.model.exception;

public class CourseIsNotEmptyException extends RuntimeException {
    public CourseIsNotEmptyException(Long id){
        super(String.format("Course with id %s is not empty", id));
    }
}
