package com.example.demo;

import java.util.Collection;


public class Instructor extends Person implements Teacher {


    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, Double numberOfHours) {
    learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, Double numberOfHours) {
        int size = 0;
        for(Object learner : learners){
            size++;
        }
        for(Learner learner : learners){
            learner.learn(numberOfHours/size);
        }
    }
}
