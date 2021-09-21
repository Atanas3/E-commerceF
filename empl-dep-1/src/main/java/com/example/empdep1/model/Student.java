package com.example.empdep1.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class Student {

    @Id
    private Long id;

    private String fullName;

    @ManyToOne
    private List<Course> courses;


    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
