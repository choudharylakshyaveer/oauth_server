package com.oauth.server.service;

import com.oauth.server.model.Users;
import com.oauth.server.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepo repo;


    public Users register(Users user) {
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        repo.save(user);
        return repo.save(user);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }

}
