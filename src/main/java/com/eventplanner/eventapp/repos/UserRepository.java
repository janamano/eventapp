package com.eventplanner.eventapp.repos;

import com.eventplanner.eventapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
