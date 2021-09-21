package com.example.empdep1.service;

import com.example.empdep1.model.Student;

import java.util.List;

public interface StudentService {
    //Gi vrakja site studenti
    List<Student> findAll();

    //Go vrakja studentot so daden indeks/id, vo sprotivno frla iskluchok
    Student findById(Long id); //throws StudentNotFoundException

    //Go brishe studentot so daden indeks/id.
    void deleteById(Long id);

    //Go zachuvuva studentot, dokolku vekje postoi student so toj indeks, se frla iskluchok
    Student save(Student student); //throws StudentAlreadyExistsException


}
