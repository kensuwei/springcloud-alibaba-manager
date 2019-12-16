package com.qf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RequestMapping
@RestController
public class UserController {

    @RequestMapping("/users")
    public Object get(HttpServletRequest request) {
        System.out.println(request.getHeader("auth"));
        return Arrays.asList("abc", "xyz");
    }
}
