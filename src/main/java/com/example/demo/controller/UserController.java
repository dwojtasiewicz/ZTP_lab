package com.example.demo.controller;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import com.example.demo.service.UserService;

//@CrossOrigin(origins = {"http://localhost:63342","http://localhost:3000","http://localhost:80", "http://localhost"})
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/register",produces = "application/json")
    public void register(@RequestBody HashMap<String, String> newUser) {
            if (newUser.containsKey("username") && newUser.containsKey("password")
                    && newUser.containsKey("firstName")&& newUser.containsKey("lastName")
                    && newUser.containsKey("numberOfPhone")&& newUser.containsKey("email")) {
                User user = new User();
                user.setUsername(newUser.get("username"));
                user.setPassword(newUser.get("password"));
                user.setFirstName(newUser.get("firstName"));
                user.setLastName(newUser.get("lastName"));
                user.setNumberOfPhone(newUser.get("numberOfPhone"));
                user.setNumberOfPhone(newUser.get("email"));
                userService.addUser(user);
            }
            else throw new SecurityException("Number of parameter is bad");
    }

    @PostMapping(path = "/update/{id}",produces = "application/json")
    public void updateUser(@PathVariable long id,@RequestBody HashMap<String, String> updateUser)
    {
        if (updateUser.containsKey("username") && updateUser.containsKey("password")
                && updateUser.containsKey("firstName")&& updateUser.containsKey("lastName")
                && updateUser.containsKey("numberOfPhone")&& updateUser.containsKey("email")) {
            User user=new User();
            user.setUsername(updateUser.get("username"));
            user.setPassword(updateUser.get("password"));
            user.setFirstName(updateUser.get("firstName"));
            user.setLastName(updateUser.get("lastName"));
            user.setNumberOfPhone(updateUser.get("numberOfPhone"));
            user.setEmail(updateUser.get("email"));
            userService.updateUser(user,id);
        }
        else throw new SecurityException("Number of parameter is bad");

    }

    @GetMapping(path = "/all",produces =  "application/json")
    public List<User> getAllUser(){
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void removeUser(@PathVariable long id)  {
        userService.removeUser(id);
    }




}

