package com.p2.jpa.basics.jpabasics.commandlinerunner;

import com.p2.jpa.basics.jpabasics.entity.User;
import com.p2.jpa.basics.jpabasics.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {//Runs when Spring Context comes up

    private static final Logger log =
            LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {

        User user = new User("Pintu", "Coding");
        Long userId = userDAOService.insert(user);

        log.info("New User created with id : " + userId);
    }
}
