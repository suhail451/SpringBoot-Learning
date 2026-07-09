package org.learnspringframework.restfullwebservices.controllers;

import jakarta.validation.Valid;
import org.learnspringframework.restfullwebservices.Exceptions.UserNotFoundException;
import org.learnspringframework.restfullwebservices.dao.UserDaoService;
import org.learnspringframework.restfullwebservices.data.User;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
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


//    http://localhost:8080/users
//    EntityModel
//    WebMvcLinkBuilder

    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user = userDao.findOne(id);

        if(user == null){
            throw new UserNotFoundException( " id : "+ id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo( methodOn( this.getClass() )
                         .getAllUsers());
        WebMvcLinkBuilder linkBuilder1 = WebMvcLinkBuilder
                .linkTo(methodOn(this.getClass()).getAllUsers());

        entityModel.add(linkBuilder.withRel("all-users"));
        entityModel.add(linkBuilder1.withRel("all-users"));
        return entityModel ;
    }

//    DeleteMapping

    @DeleteMapping("/users/{id}")
    public  ResponseEntity<User> deleteUser( @PathVariable int id){
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
