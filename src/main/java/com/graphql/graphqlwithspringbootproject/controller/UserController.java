package com.graphql.graphqlwithspringbootproject.controller;

import com.graphql.graphqlwithspringbootproject.model.User;
import com.graphql.graphqlwithspringbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @MutationMapping("createUser")
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password){
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllData(){
        return userService.getAllData();
    }


    @QueryMapping(name = "getUser")
    public Optional<User> getDataById(@Argument int userId){
        Optional<User> user = userService.getDataById(userId);
        return user;
    }

    @MutationMapping(name = "deleteUser")
    public String deleteData(@Argument int userId){
        return userService.deleteData(userId);
    }

    @MutationMapping(name = "updateUser")
    public User updateData(@Argument int userId, @Argument String name, @Argument String phone, @Argument String email, @Argument String password){

        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.updateData(userId,user);
    }
}
