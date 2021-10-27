package com.yusufu.springsecuritydemo.security;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/**
 * yusufu 25.10.2021 .
 */
@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USERNAME",nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
