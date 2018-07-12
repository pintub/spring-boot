package com.p2.jpa.basics.jpabasics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource bundleMessageSource;

    @GetMapping("hello-world-internationalized")
    public String getHelloWorld(@RequestHeader(name = "Accept-Language", required = false)Locale locale){
        return bundleMessageSource.getMessage("hello.world.message", null,
                locale);
    }

    @GetMapping("hello-world")
    public String getHelloWorld(){
        return "Hello World";
    }

}
