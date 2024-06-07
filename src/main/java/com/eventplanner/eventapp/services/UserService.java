package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findUserById(int id);

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(int id);

}
