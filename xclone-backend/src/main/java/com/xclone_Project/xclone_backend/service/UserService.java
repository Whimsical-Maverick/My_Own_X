package com.xclone_Project.xclone_backend.service;

import com.xclone_Project.xclone_backend.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xclone_Project.xclone_backend.repository.UserRepository;


@Service
public class UserService{
    
    @Autowired
    private UserRepository userRepository;

    boolean isUsernameTaken(String username){
        return userRepository.findbyUsername(username) != null;
    }
    boolean isEmailTaken(String emailId){
        return userRepository.findbyEmailId(emailId) != null;
    }
    boolean isPasswordTaken(String password){
        return userRepository.findbyPassword(password) != null;
    }

    void saveUser(User user)
    {
        if(isUsernameTaken(user.getUsername()) || isEmailTaken(user.getEmailId()) || isPasswordTaken(user.getPassword())){
            throw new IllegalArgumentException("Username, email or password already exists");
        }
        else userRepository.save(user);
    }

    List<User> getUser(String username,String password)
    {
        if(isUsernameTaken(username) && isPasswordTaken(password)){
            return userRepository.findbyUsername(username);
        }
        else throw new IllegalArgumentException("Username or password is incorrect OR user does not exist");
    }

}
