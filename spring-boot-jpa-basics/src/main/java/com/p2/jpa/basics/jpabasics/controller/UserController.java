package com.p2.jpa.basics.jpabasics.controller;

import com.p2.jpa.basics.jpabasics.entity.User;
import com.p2.jpa.basics.jpabasics.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
         Optional<User> user = userRepository.findById(id);
         return user.get();
    }

    @PostMapping("/userV2")
    public User getUserV2(@RequestBody User user){
        Optional<User> userById = userRepository.findById(user.getId());

        User userFound = null;

        try {
            userFound = userById.get();
        } catch (NoSuchElementException e){
            throw new UnsupportedOperationException("User " + user.getId() + " Not found ..");
        }

        return userFound;
    }
}
