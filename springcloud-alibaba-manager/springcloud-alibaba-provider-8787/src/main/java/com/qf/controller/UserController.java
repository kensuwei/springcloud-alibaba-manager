package com.qf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequestMapping
@RestController
public class UserController {

    @RequestMapping("/users")
    public Object get() {
        return Arrays.asList("ABC", "LMN");
    }
}
