package org.learnspringframework.restfullwebservices.controllers;

import org.learnspringframework.restfullwebservices.dao.UserDaoService;
import org.learnspringframework.restfullwebservices.data.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService userDao;


    public UserResource(UserDaoService userDao) {
        this.userDao = userDao;
    }


//    Get all Users / Retrive all Users.

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

//    get user by id
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return userDao.findOne(id);
    }

//    Save the data
    @PostMapping("/users")
    public void createUser(@RequestBody User user ){
        userDao.save(user);
    }


}
