package com.eventplanner.eventapp.rest;

import com.eventplanner.eventapp.entities.User;
import com.eventplanner.eventapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return this.userService.findAll();
    }

    @GetMapping("users/{userId}")
    public User getUserById(@PathVariable int userId) {
        return this.userService.findUserById(userId);
    }

    @PostMapping("users")
    public User createUser(@RequestBody User user) {
        user.setId(0);
        User newUser = this.userService.createUser(user);
        return newUser;
    }

    @PutMapping("users")
    public User updateUser(@RequestBody User user) {
        User newUser = this.userService.updateUser(user);
        return newUser;
    }

    @DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        this.userService.deleteUser(userId);
    }
}
