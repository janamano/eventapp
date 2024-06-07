package com.eventplanner.eventapp.repos;

import com.eventplanner.eventapp.entities.EventAttendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventAttendeesRepository extends JpaRepository<EventAttendees, Integer> {

    @Query("SELECT i FROM EventAttendees i WHERE i.event.id = :eventId")
    public List<EventAttendees> findByEventId(int eventId);


    @Query("SELECT i FROM EventAttendees i WHERE i.user.id = :userId")
    public List<EventAttendees> findByUserId(int userId);
}
