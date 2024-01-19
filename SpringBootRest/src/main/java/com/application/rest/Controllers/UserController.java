package com.application.rest.Controllers;

import com.application.rest.Models.User;
import com.application.rest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<User> getUsers(){
        return this.userService.getUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PutMapping
    public User updateById(@RequestBody User request, Long id){
        return this.userService.updateById(request,id);
    }

    @DeleteMapping(path = {"/id"})
    public String deleteById(@PathVariable Long id){
        boolean ok = this.userService.deleteById(id);
        if(ok){
            return "user with id: " + id + "has been deleted";
        }   else return "user hasn't been deleted, try again later";
    }




}
