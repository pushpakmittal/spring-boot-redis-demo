package com.myapp.springredisdemo.service;

import com.myapp.springredisdemo.model.User;
import com.myapp.springredisdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
