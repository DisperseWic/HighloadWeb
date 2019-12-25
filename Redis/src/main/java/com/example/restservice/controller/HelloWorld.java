package com.example.restservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import redis.clients.jedis.*;
import redis.clients.util.*;

@RestController
public class HelloWorld {
    AtomicLong count = new AtomicLong(0);
    Jedis jedis = new Jedis("localhost");


    @RequestMapping("/get")
    String hello() {
        return jedis.get("key");
    }
    @RequestMapping("/increment")
    void increment(){
        jedis.incr("key");
    }
    @RequestMapping("/redis")
    void redis(){
        jedis.del("key");
        jedis.set("key","0");
    }
}


