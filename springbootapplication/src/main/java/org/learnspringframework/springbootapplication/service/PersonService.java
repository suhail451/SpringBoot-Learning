package org.learnspringframework.springbootapplication.service;

import org.learnspringframework.springbootapplication.Data.Persons;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {


    private final Persons persons;

    public PersonService(Persons persons) {
        this.persons = persons;
    }

    public List<Persons> getAllUsers(){
        return Arrays.asList(
                new Persons(1, "Palak", "gpalakKeeran@gmail.com", 18),
                new Persons(2,"Keertan", "gkeertangoswami@gmail.com", 23),
                new Persons(2,"Rohan", "rohan@gmail.com", 12),
                new Persons(3, "Lakesh", "lakesh@gmail.com", 15),
                new Persons(4,"Parshant", "parshant@gmail.com", 18),
                new Persons(6,"Parshant2", "parshant@gmail.com", 18),
                new Persons(7,"Parshant3", "parshant@gmail.com", 18)
        );
    }


}
