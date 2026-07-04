package org.learnspringframework.restfullwebservices.controllers;

import jakarta.validation.Valid;
import org.learnspringframework.restfullwebservices.Exceptions.UserNotFoundException;
import org.learnspringframework.restfullwebservices.dao.UserDaoService;
import org.learnspringframework.restfullwebservices.data.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDao.findOne(id);

        if(user == null){
            throw new UserNotFoundException( " id : "+ id);
        }

        return user ;
    }

//    DeleteMapping

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser( @PathVariable int id){
        userDao.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //    Save the data
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user ){
        User savedUser = userDao.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand( savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }




}
