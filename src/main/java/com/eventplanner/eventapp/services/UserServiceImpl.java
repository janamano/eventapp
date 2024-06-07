package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.User;
import com.eventplanner.eventapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            // todo
            return null;
        }
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
//        this.userRepository.
        return this.userRepository.save(user);

    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

}
