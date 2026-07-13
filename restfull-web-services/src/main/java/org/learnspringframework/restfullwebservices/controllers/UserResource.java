package org.learnspringframework.restfullwebservices.controllers;

import jakarta.validation.Valid;
import org.learnspringframework.restfullwebservices.Exceptions.UserNotFoundException;
import org.learnspringframework.restfullwebservices.data.UserJpa;
import org.learnspringframework.restfullwebservices.service.UserService;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {



     private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    //    Get all Users / Retrive all Users.

    @GetMapping
    public List<UserJpa> getAllUsers(){
        return userService.findAll();
    }

//    get user by id


//    http://localhost:8080/users
//    EntityModel
//    WebMvcLinkBuilder

    @GetMapping("/{id}")
    public EntityModel<UserJpa> getUser(@PathVariable Long id){
        UserJpa user = userService.findOne(id);

        if(user == null){
            throw new UserNotFoundException( " id : "+ id);
        }

        EntityModel<UserJpa> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo( methodOn( this.getClass() )
                         .getAllUsers());
        WebMvcLinkBuilder linkBuilder1 = WebMvcLinkBuilder
                .linkTo(methodOn(this.getClass()).getAllUsers());

        entityModel.add(linkBuilder.withRel("all-users"));
        entityModel.add(linkBuilder1.withRel("all-users"));
        return entityModel ;
    }

//    DeleteMapping

    @DeleteMapping("/{id}")
    public  ResponseEntity<UserJpa> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //    Save the data
    @PostMapping
    public ResponseEntity<UserJpa> createUser(@Valid @RequestBody UserJpa user ){
        UserJpa savedUser = userService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand( savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }


}
