package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorsConfigTest {

    @Autowired
    @Qualifier("tcUSA")
    Instructors usInstructors;

    @Autowired
    @Qualifier("tcUk")
    Instructors ukInstructors;

    @Autowired
    Instructors instructors;

    @Test
    public void sizeTest(){
        int expected = Names.tcUkInstructors.length + Names.tcUsaInstructors.length;
        int actual = instructors.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void tcUsaInstructors() {
        usInstructors.findAll().forEach(instructor -> Assert.assertTrue(Arrays.asList(Names.tcUsaInstructors).contains(instructor.getName())));
    }

    @Test
    public void tcUkInstructors() {
        ukInstructors.findAll().forEach(instructor -> Assert.assertTrue(Arrays.asList(Names.tcUkInstructors).contains(instructor.getName())));
    }

    @Test
    public void getAllInstructors() {
        instructors.findAll().forEach(instructor -> Assert.assertTrue(Arrays.asList(Names.tcUkInstructors).contains(instructor.getName())||Arrays.asList(Names.tcUsaInstructors).contains(instructor.getName())));
    }
}