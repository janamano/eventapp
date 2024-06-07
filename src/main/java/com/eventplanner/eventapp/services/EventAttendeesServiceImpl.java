package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.EventAttendees;
import com.eventplanner.eventapp.repos.EventAttendeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAttendeesServiceImpl implements EventAttendeesService {
    private EventAttendeesRepository eventAttendeesRepository;

    @Autowired
    public EventAttendeesServiceImpl(EventAttendeesRepository eventAttendeesRepository) {
        this.eventAttendeesRepository = eventAttendeesRepository;
    }

    @Override
    public EventAttendees saveEventAttendee(EventAttendees eventAttendee) {
        return this.eventAttendeesRepository.save(eventAttendee);
    }

    @Override
    public List<EventAttendees> getEventAttendeesByEventId(int eventId) {
        // list of users for the one event
        List<EventAttendees> res = this.eventAttendeesRepository.findByEventId(eventId);

        return res;
    }

    @Override
    public List<EventAttendees> getEventAttendeesByUserId(int userId) {
        // list of events for the one user
        List<EventAttendees> res = this.eventAttendeesRepository.findByUserId(userId);

        return res;
    }
}
