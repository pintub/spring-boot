package com.p2.springboot.basics.springboot.restcontroller;

import com.p2.springboot.basics.springboot.bean.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks(){
        return Arrays.asList(new Book(1, "Spring Basics 0.1", "Pin2"));
    }
}
