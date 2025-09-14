package com.oauth.server.repo;

import com.oauth.server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.username = ?1")
    Optional<Users> findByUsername(String username);
}
