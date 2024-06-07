package com.eventplanner.eventapp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
