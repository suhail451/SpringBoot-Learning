package org.learnspringframework.jpaandhibernateapplication.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.learnspringframework.jpaandhibernateapplication.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

//    Custom Methods

    public List<Course> findByAuthor(String name);
    public List<Course> findByTitle(String title);



}
