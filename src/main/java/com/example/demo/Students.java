package com.example.demo;

import java.util.Iterator;

public class Students extends People<Student> {

    public Students(Student[] people) {
        super(people);
    }

    @Override
    public Iterator<Student> iterator() {
        return super.iterator();
    }


}
