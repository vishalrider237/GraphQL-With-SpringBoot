package com.springboot.graphql.springbootwithgraphql.service;

import com.springboot.graphql.springbootwithgraphql.entity.User;
import com.springboot.graphql.springbootwithgraphql.helper.CustomException;
import com.springboot.graphql.springbootwithgraphql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User saveUser(User user) {
        return userRepo.save(user);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public User getSingleUser(int id) {
        User user = userRepo.findById(id).orElseThrow(CustomException::throwResourceNotFoundException);
        return user;
    }
    public boolean deleteUser(int id) {
        User user = userRepo.findById(id).orElseThrow(CustomException::throwResourceNotFoundException);
        this.userRepo.delete(user);
      return true;
    }

    public User updateUser(int userId, String userName, String email, String password, String phone) throws Exception {
        User user = userRepo.findById(userId).orElseThrow(CustomException::throwResourceNotFoundException);
        if (user == null) {
            throw new Exception("User not found");
        }
        user.setPassword(password);
        user.setEmail(email);
        user.setUserName(userName);
        user.setPhone(phone);
        this.userRepo.save(user);
        return user;
    }
}
