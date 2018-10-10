package com.p2.jpa.basics.jpabasics.controller;

import com.p2.jpa.basics.jpabasics.entity.Post;
import com.p2.jpa.basics.jpabasics.entity.User;
import com.p2.jpa.basics.jpabasics.exception.UserNotFoundException;
import com.p2.jpa.basics.jpabasics.service.PostRepository;
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

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //HATEOAS
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
    //Validation of Request Body Bean
    @PostMapping("/createUser")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user")
                .path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsOfaUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable long id, @RequestBody Post post) {

        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        User user = userOptional.get();

        post.setUser(user);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
