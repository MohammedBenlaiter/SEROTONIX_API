package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/helloWorld")
public class HelloWorld {
    @GetMapping
    public String Hello() {
        return "Hello World";
    }
}
