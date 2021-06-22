package com.study.controller;

import com.study.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/info")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = new User();
        user.setUserName("test");
        user.setPassWord("test");
       return user;
    }

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID)session.getAttribute("uid");
        if(uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
