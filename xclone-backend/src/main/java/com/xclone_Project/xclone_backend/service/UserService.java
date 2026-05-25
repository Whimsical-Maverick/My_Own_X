package com.xclone_Project.xclone_backend.service;

import com.xclone_Project.xclone_backend.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xclone_Project.xclone_backend.repository.UserRepository;


@Service
public class UserService{
    
    @Autowired
    private UserRepository userRepository;

    public boolean isUsernameTaken(String username)
    {
        return userRepository.existsByUsername(username);
    }

    public boolean isEmailTaken(String emailId)
    {
        return userRepository.existsByEmailId(emailId);
    }

    public void setcreationTime(User user)
    {
        user.setCreationTime(java.time.LocalDateTime.now());
    }

    public void saveUser(User user)
    {
        if(isUsernameTaken(user.getUsername()) || isEmailTaken(user.getEmailId())){
            throw new IllegalArgumentException("Username or email already exists");
        }
        else 
        {
            setcreationTime(user);
            userRepository.save(user);
        }
    }

    public User getUserByUsername(String username,String password)
    {
        if(isUsernameTaken(username) )
        {
            User u = userRepository.findByUsername(username);

            if(u.getPassword().equals(password))
            {
                return u;
            }
            else throw new IllegalArgumentException("password is incorrect");
        }
        else throw new IllegalArgumentException("username not registered");
    }

    public User getUserByEmailId(String emailId,String password)
    {
        if(isEmailTaken(emailId) )
        {
            User u = userRepository.findByEmailId(emailId);
            if(u.getPassword().equals(password))
            {
                return u;
            }
            else throw new IllegalArgumentException("password is incorrect");
        }
        else throw new IllegalArgumentException("email account not registered");
    }

}
