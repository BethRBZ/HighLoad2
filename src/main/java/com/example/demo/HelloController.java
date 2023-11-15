package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    int counter = 0;
        @GetMapping("/hello")
        int hello() {
            ++counter;
            LOGGER.info("Counter: {}", counter);
            return counter;
        }
}


