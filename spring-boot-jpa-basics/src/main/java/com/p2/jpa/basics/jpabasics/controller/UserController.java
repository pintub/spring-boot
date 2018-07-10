package com.p2.jpa.basics.jpabasics.controller;

import com.p2.jpa.basics.jpabasics.entity.User;
import com.p2.jpa.basics.jpabasics.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Resource<User> getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        //Add Link
        //"all-users", SERVER_PATH + "/users"
        //retrieveAllUsers
        Resource<User> resource = new Resource<User>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/userV2")
    public User getUserV2(@RequestBody User user) {
        Optional<User> userById = userRepository.findById(user.getId());

        User userFound = null;

        try {
            userFound = userById.get();
        } catch (NoSuchElementException e) {
            throw new UnsupportedOperationException("User " + user.getId() + " Not found ..");
        }

        return userFound;
    }

    //Best practice to return URI of newly created resource for POST method
    @PostMapping("/createUser")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user")
                .path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
