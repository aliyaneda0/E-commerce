package com.aliya.E_commerce.controller;


import com.aliya.E_commerce.model.User;
import com.aliya.E_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

}
