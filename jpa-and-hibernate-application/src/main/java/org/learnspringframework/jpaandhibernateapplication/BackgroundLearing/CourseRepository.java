package org.learnspringframework.jpaandhibernateapplication.BackgroundLearing;

import org.learnspringframework.jpaandhibernateapplication.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    @Autowired
    private JdbcTemplate springJdbcTemtplete;


//    Create
    private static String INSERT_QUERY =
            """
                insert into course(id, title, author) 
                values (?,?,?);
            """;

    public void insert(Course course){
        springJdbcTemtplete.update(INSERT_QUERY,
                course.getId(), course.getTitle(), course.getAuthor());
    }

//    Delete
    private String DELETE_QUERY=  """
                delete from course where id = ?
            """;
    public void delete(Long id){
        springJdbcTemtplete.update(DELETE_QUERY, id);
    }


//    Select
    private String SELECT_QUERY = """
                select * from course where id = ?
            """;
    public Course getCourseById(Long id){
        return springJdbcTemtplete.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }


}
