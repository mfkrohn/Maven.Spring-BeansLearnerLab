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
public class StudentConfigTest {

    @Autowired
    @Qualifier("students")
    Students currentStudents;

    @Autowired
    @Qualifier("previousStudents")
    Students previousStudents;

    @Test
    public void testSize(){
    int expected = Names.currentStudentsNames.length;
    int actual = currentStudents.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testPrevSize(){
        int expected = Names.previousStudentsNames.length;
        int actual = previousStudents.size();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void currentStudents() {
        currentStudents.findAll().forEach(student -> Assert.assertTrue(Arrays.asList(Names.currentStudentsNames).contains(student.getName())));
    }

    @Test
    public void previousStudents() {
        previousStudents.findAll().forEach(student -> Assert.assertTrue(Arrays.asList(Names.previousStudentsNames).contains(student.getName())));
    }
}