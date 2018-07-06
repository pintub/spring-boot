package com.p2.jpa.basics.jpabasics.commandlinerunner;

import com.p2.jpa.basics.jpabasics.entity.User;
import com.p2.jpa.basics.jpabasics.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {//Runs when Spring Context comes up

    private static final Logger log =
            LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User("Chin2", "NGO");
        userRepository.save(user);
        log.info("New User created with id : " + user);

        Optional<User> userWithIdOne = userRepository.findById(1l);
        log.info("Retrieved User with id 1: " + userWithIdOne);

        List<User> userList = userRepository.findAll();
        log.info("Retrieved All Users : " + userList);

    }
}
