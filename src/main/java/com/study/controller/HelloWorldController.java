package com.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(value = "/world/{id}")
    public String world(@PathVariable("id") Integer id, @RequestHeader("User-Agent") String userAgent) {
        return "Hello World." + id + " " +userAgent;
    }
}
