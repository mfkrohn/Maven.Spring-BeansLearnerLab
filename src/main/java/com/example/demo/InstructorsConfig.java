package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class InstructorsConfig {




    @Bean(name = "tcUSA")
    public Instructors tcUsaInstructors(){
    return getInstructors(Names.tcUsaInstructors);
}

    @Bean(name = "tcUk")
    public Instructors tcUkInstructors(){
        return getInstructors(Names.tcUkInstructors);
    }

    @Bean
    @Primary
    public Instructors instructors(){
        List<Instructor> instructorsList = tcUsaInstructors().findAll();
        instructorsList.addAll(tcUkInstructors().findAll());
        return new Instructors(instructorsList.toArray(new Instructor[0]));
    }

    private Instructors getInstructors(String[] instructors){
    List<Instructor> list = new ArrayList<>();
    Stream.of(instructors).forEach(studentName -> list.add(new Instructor(idGenerator.getInstance().getId(), studentName)));
    return new Instructors(list.toArray(new Instructor[0]));
}

}
