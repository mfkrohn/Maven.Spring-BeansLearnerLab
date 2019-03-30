package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class  People<PersonType extends Person> implements Iterable<PersonType> {

    private List<PersonType> personList;

    public People(List<PersonType> personList) {
        this.personList = personList;
    }

    public People(PersonType[] people){
        personList = new ArrayList<>();
        this.personList.addAll(Arrays.asList(people));

    }

    public void add(PersonType person){
        personList.add(person);
    }

    public void remove(PersonType person){
        personList.remove(person);
    }

    public Integer size(){
        return personList.size();
    }

    public void clear(){
        personList.clear();
    }

    public void addAll(Iterable<PersonType> people){
        people.forEach(person -> personList.add(person));
    }

    public PersonType findById(Long id){
        return personList.stream().filter(personType -> personType.getId()==id).findFirst().get();
    }

    public List<PersonType> findAll(){
        return personList;
    }

    @Override
    public String toString() {
        return "People{" +
                "personList=" + personList +
                '}';
    }

    @Override
    public Iterator<PersonType> iterator() {
        return personList.iterator();
    }
}
