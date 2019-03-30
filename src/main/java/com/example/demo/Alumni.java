package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {

    @Autowired
    @Qualifier("previousStudents")
    private Students alumni;

    @Autowired
    @Qualifier("instructors")
    private Instructors instructors;

    @PostConstruct
    public void executeBootcamp(){
        instructors.forEach
                (instructor -> instructor.
                        lecture(alumni,
                                alumni.size()*(1200.0/(Names.tcUsaInstructors.length+Names.tcUkInstructors.length))));
    }

    public Students getAlumni() {
        return alumni;
    }

    public Instructors getInstructors() {
        return instructors;
    }
}
