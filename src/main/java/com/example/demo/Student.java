package com.example.demo;

public class Student extends Person implements Learner{


    private Double totalStudyTime;

    public Student(Long id, String name) {
        super(id, name);
        this.totalStudyTime = 0.0;
    }


    @Override
    public void learn(double numberOfHours) {
        totalStudyTime += numberOfHours;
    }

    public Double getTotalStudyTime() {
        return totalStudyTime;
    }
}
