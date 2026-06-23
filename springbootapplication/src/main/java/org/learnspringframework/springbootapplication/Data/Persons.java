package org.learnspringframework.springbootapplication.Data;

import org.springframework.stereotype.Component;


public class Persons {

    private int id;
    private String Name;
    private String email;
    private int age;

    public Persons(){};

    public Persons(int id, String name, String email, int age) {
        this.id = id;
        Name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
