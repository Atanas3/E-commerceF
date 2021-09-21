package com.example.empdep1.service;

import com.example.empdep1.model.Course;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseService {
    //Gi vrakja site kursevi
    List<Course> findAll();

    //Go bara kursot sproed id, vo sprotivno frla iskluchok
    Course findById(Long id); //throws CourseNotFoundException

    //Zachuvuvanje na kursot
    Course save(Course course);

    //Update na kursot so dadeno id
    Course update(Long id, Course course); //throws CourseNotFoundException

    //Brishenje na kursot. Dokolku ima studenti koi go slushaat, se frla iskluchok
    void deleteById(Long id); //throws CourseIsNotEmptyException

    //Dodavanje na student na daden kurs, frla iskluchok ako vekje studentot e dodaden na kursot.
    Course addStudentToCourse(Long studentId, Long courseId); //throws StudentIsAlreadyEnrolledException

    //Brishenje na student od kursot.
    Course removeStudentFromCourse(String studentId, Long courseId);



    //Za dolnite dva metodi, nema potreba od mapiranje vo kontroler
    //Dovolno e samo da se implementiraat metodite vo service i repository

    //Gi vrakja kursot so dadenoto ime, vo sprotivno frla iskluchok deka ne postoi
    //Pozhelno e da se reshi na nivo na repository
    Course findCourseByName(String name); //throws CourseNotFoundException

    //Gi vrakja site kursevi koi se kreirani pred datumot koj e praten kako argument vo funkcijata
    //Pozhelno e da se reshi na nivo na repository
    List<Course> findAllCoursesOlderThan(LocalDateTime localDateTime);

}
