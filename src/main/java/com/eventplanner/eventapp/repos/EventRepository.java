package com.eventplanner.eventapp.repos;

import com.eventplanner.eventapp.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
