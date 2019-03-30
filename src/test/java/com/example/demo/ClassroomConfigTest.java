package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassroomConfigTest {

    @Autowired
    @Qualifier("currentCohort")
    Classroom currentCohort;

    @Autowired
    @Qualifier("previousCohort")
    Classroom previousCohort;

    @Test
    public void students(){
        previousCohort.students.forEach(student -> System.out.println(student.getName()));
    }

    @Test
    public void currentCohort() {
    currentCohort.instructors.forEach(instructor -> Assert.assertTrue(Arrays.asList(Names.tcUkInstructors).contains(instructor.getName())||Arrays.asList(Names.tcUsaInstructors).contains(instructor.getName())));
    currentCohort.students.forEach(student -> Assert.assertTrue(Arrays.asList(Names.currentStudentsNames).contains(student.getName())));
    }

    @Test
    public void previousCohort() {
        previousCohort.instructors.forEach(instructor -> Assert.assertTrue(Arrays.asList(Names.tcUkInstructors).contains(instructor.getName())||Arrays.asList(Names.tcUsaInstructors).contains(instructor.getName())));
        previousCohort.students.forEach(student -> Assert.assertTrue(Arrays.asList(Names.previousStudentsNames).contains(student.getName())));
    }
}