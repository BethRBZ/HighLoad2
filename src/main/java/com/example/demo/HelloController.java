package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPooled;

@RestController
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    JedisPooled jedis = new JedisPooled("localhost", 6379);

    int counter = 0;
        @GetMapping("/hello")
        int hello() {
            ++counter;
            String count = Integer.toString(counter);
            jedis.set("Counter", count);
            LOGGER.info("Counter: {}", jedis.get("Counter"));
            return counter;
        }
}


