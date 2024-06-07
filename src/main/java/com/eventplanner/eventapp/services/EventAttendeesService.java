package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.EventAttendees;

import java.util.List;

//@Service
public interface EventAttendeesService {
    EventAttendees saveEventAttendee(EventAttendees eventAttendee);
    List<EventAttendees> getEventAttendeesByEventId(int eventId);
    List<EventAttendees> getEventAttendeesByUserId(int userId);
}
