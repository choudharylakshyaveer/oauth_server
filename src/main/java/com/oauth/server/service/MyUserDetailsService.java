package com.oauth.server.service;

import com.oauth.server.model.Users;
import com.oauth.server.repo.UserPrincipal;
import com.oauth.server.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Looking for user with username: {}", username);
        Users user = userRepo.findByUsername(username).orElse(null);
        if (user == null) {
            log.error("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserPrincipal(user);
    }
}
