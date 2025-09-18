package com.oauth.server.model;

import com.oauth.server.converter.RoleConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(
        name="Users",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"username"}))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String username;
    private String password;

    @Column(length = 200)
    @Convert(converter = RoleConverter.class)
    private Set<Role> roles;  // e.g. [ROLE_USER, ROLE_ADMIN]
}
