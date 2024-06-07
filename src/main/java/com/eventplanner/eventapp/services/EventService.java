package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.Event;

import java.util.List;

public interface EventService {

    public Event createEvent(Event event);

    public Event getEventById(int id);

    public List<Event> getAllEvents();

    public Event updateEvent(Event event);

    public void deleteEvent(int id);
}