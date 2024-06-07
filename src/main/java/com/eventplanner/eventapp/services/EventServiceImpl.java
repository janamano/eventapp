package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.Event;
import com.eventplanner.eventapp.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Event createEvent(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Event getEventById(int id) {
        Optional<Event> eventRes = this.eventRepository.findById(id);
        if (eventRes.isPresent()) {
            return eventRes.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event updateEvent(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public void deleteEvent(int id) {
        this.eventRepository.deleteById(id);
    }
}
