package com.aliya.E_commerce.service;

import com.aliya.E_commerce.model.User;
import com.aliya.E_commerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public User loginUser(String email, String password){

        // to check if user exist or not
       User user =  userRepository.findByEmail(email);

       if (user != null && user.getPassword().equals(password) ){

           return user;

       }
       return null;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
