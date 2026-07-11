package org.learnspringframework.jpaandhibernateapplication.BackgroundLearing;

import org.learnspringframework.jpaandhibernateapplication.Entity.Course;
import org.learnspringframework.jpaandhibernateapplication.repository.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseRepository courseRepository;

//    @Autowired
//    private CourseJpaRepository courseRepository;

    @Autowired
    private CourseSpringDataJpaRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        courseRepository.save(new Course(1l,"Java to Microservices", "Keertan Gir"));
        courseRepository.save(new Course(2l,"Python fundamental", "Palak Goswami"));
        courseRepository.save(new Course(3l, "C# Backend Development", "Chander Kumar"));


        courseRepository.deleteById(1l);

        System.out.println(courseRepository.findById(2l));
        System.out.println(courseRepository.findById(3l));

        System.out.println(courseRepository.findByAuthor("Palak Goswami"));

        System.out.println(courseRepository.findByTitle("Java to Microservices"));

    }
}
