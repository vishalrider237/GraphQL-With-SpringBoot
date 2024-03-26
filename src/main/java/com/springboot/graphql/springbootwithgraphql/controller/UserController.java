package com.springboot.graphql.springbootwithgraphql.controller;

import com.springboot.graphql.springbootwithgraphql.entity.User;
import com.springboot.graphql.springbootwithgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @MutationMapping
    public User createUser(@Argument String userName,@Argument String email,@Argument String password,@Argument String phone){
       User user=new User();
       user.setUserName(userName);
       user.setEmail(email);
       user.setPassword(password);
       user.setPhone(phone);
        return userService.saveUser(user);
    }
    @QueryMapping(name = "getUsers")
    public List<User>getUsers(){
        return this.userService.getAllUsers();
    }
    @QueryMapping
    public User getUser(@Argument int userId){
        return this.userService.getSingleUser(userId);
    }
    @MutationMapping
    public User updateUser(@Argument int userId,@Argument String userName,@Argument String email,@Argument String password,@Argument String phone) throws Exception {
        return this.userService.updateUser(userId,userName,email,password,phone);
    }
    @MutationMapping
    public  boolean deleteUser(@Argument int userId){
        return this.userService.deleteUser(userId);
    }
}
