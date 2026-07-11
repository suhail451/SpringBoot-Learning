package org.learnspringframework.jpaandhibernateapplication.BackgroundLearing;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.learnspringframework.jpaandhibernateapplication.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @Autowired
    EntityManager entityManager;

    public void insert(Course course){

        entityManager.persist(course);

    }

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }



}
