package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlumniTest {

    @Autowired
    @Qualifier("previousStudents")
    Students alumni;


    @Test
    public void executeBootcamp() {
        Double expectedHours = 1200.0;
        alumni.forEach(student -> Assert.assertEquals(expectedHours,student.getTotalStudyTime()));
    }
}