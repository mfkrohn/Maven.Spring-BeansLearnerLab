package com.example.demo;

public class idGenerator {
    private static idGenerator instance = null;
    Long id;

    private idGenerator() {
        id = 0L;
    }

    public Long getId() {
        id++;
        return id;
    }

    public static idGenerator getInstance(){
       if (instance == null){
           instance = new idGenerator();
       }

        return instance;
    }
}
