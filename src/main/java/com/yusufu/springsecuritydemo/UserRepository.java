package com.yusufu.springsecuritydemo;

import com.yusufu.springsecuritydemo.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
