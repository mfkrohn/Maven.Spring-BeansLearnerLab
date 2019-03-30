package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class StudentConfig {


    @Bean(name = "students")
    public Students currentStudents(){
        return getStudents(Names.currentStudentsNames);
    }

    @Bean
    public Students previousStudents(){
        return getStudents(Names.previousStudentsNames);
    }

    private Students getStudents(String[] StudentsNames) {
        List<Student> list = new ArrayList<>();
        Stream.of(StudentsNames).forEach(studentName -> list.add(new Student(idGenerator.getInstance().getId(), studentName)));
        return new Students(list.toArray(new Student[0]));
    }

}
