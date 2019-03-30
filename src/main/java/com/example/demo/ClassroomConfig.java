package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
@Configuration
public class ClassroomConfig {
    @Autowired
    private StudentConfig studentConfig;
    @Autowired
    private InstructorsConfig instructorsConfig;

    @Bean()
    //@DependsOn({"instructors,students"})
    public Classroom currentCohort(){
   return new Classroom(instructorsConfig.instructors(),studentConfig.currentStudents());
    }

    @Bean()
    //@DependsOn({"instructors,previousStudents"})
    public Classroom previousCohort(){
        return new Classroom(instructorsConfig.instructors(),studentConfig.previousStudents());
    }
}
