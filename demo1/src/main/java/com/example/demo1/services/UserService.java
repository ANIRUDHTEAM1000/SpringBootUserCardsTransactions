package com.example.demo1.services;

import com.example.demo1.models.User;
import com.example.demo1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User add(User u)
    {
        return userRepo.save(u);
    }

}
