package com.example.demo;

import java.util.Iterator;

public class Instructors extends People<Instructor> {


    public Instructors(Instructor[] people) {
        super(people);
    }

    @Override
    public Iterator<Instructor> iterator() {
        return super.iterator();
    }
}
