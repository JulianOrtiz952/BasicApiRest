package com.application.rest.Services;

import com.application.rest.Models.User;
import com.application.rest.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    
    public ArrayList<User> getUser(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    public User updateById(User request, Long id){
        User user = userRepository.findById(id).get();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return user;
    }

    public boolean deleteById(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
