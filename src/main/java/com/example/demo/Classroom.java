package com.example.demo;

import java.util.List;

public class Classroom {

    Instructors instructors;
    Students students;

    public Classroom(Instructors instructors, Students students) {
        this.instructors = instructors;
        this.students = students;
    }

    public void hostLecture(Teacher teacher, Double numberOfHours){
        teacher.lecture(students.findAll(),numberOfHours);
    }
}
