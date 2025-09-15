package com.oauth.server.controller;

import com.oauth.server.model.Users;
import com.oauth.server.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return usersService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return usersService.verify(user);
    }
}
