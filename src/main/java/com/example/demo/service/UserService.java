package com.example.demo.service;


import com.example.demo.entity.Cat;
import com.example.demo.entity.User;
import com.example.demo.repo.CatRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.repo.UserRepo;

import java.util.List;

@Service
public class UserService {


    private UserRepo userRepo;
    private CatRepo catRepo;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo, CatRepo catRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.catRepo = catRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
    }

    public void updateUser(User user,long id){
        User updateUser = userRepo.findById(id);
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setNumberOfPhone(user.getNumberOfPhone());
        updateUser.setEmail(user.getEmail());
        userRepo.save(updateUser);
    }

    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }

    public User getUser(long id){
        return userRepo.findById(id);
    }

    public void removeUser(long id) {
        User user;
        user = userRepo.findById(id);
        for(Cat cat : user.getCats())
        {
           catRepo.delete(cat);
        }
        userRepo.delete(user);
    }


}
