package com.services;

import com.domain.User;
import com.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource(value = "classpath:application.properties")
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
       return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.getUserById(id);
    }


}
