package com.oauth.server.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest httpServletRequest) {
        return "Welcome to JWT authentication! \n Your session id is:" + httpServletRequest.getSession().getId();
    }
}
