package com.example.redisTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @GetMapping("/session")
    public String session(HttpSession session) {
        session.setAttribute("user", "id1");
        Object user = session.getAttribute("user");
        return user.toString();

    }

    @GetMapping("/test")
    public String test(HttpSession session) {

        Object user = null;
        if (session.getAttribute("user") == null || session == null) {
            return "no Session";
        }
        user = session.getAttribute("user");
        return user.toString();

    }


}
