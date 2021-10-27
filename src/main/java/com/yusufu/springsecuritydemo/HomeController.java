package com.yusufu.springsecuritydemo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yusufu 25.10.2021 .
 */

@RestController
public class HomeController {

    @GetMapping("/user")
    //@PreAuthorize("hasAnyRole('ROLE_USER','USER')")
    public String userTest(){
        return "API user";
    }

    @GetMapping("/admin")
    //@Secured("ROLE_ADMIN")
    public String adminTest(){
        return "API ADMIN";
    }
}
