package com.oauth.server.service;

import com.oauth.server.model.Role;
import com.oauth.server.model.Users;
import com.oauth.server.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsersService {

    private final UserRepo repo;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UsersService(UserRepo repo, AuthenticationManager authManager, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repo = repo;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Set.of(Role.ROLE_USER)); // default role
        }
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication authenticate = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if (authenticate.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authenticate.getPrincipal();
            return jwtService.generateToken(userDetails);
        }
        return "FAIL";
    }

}
