package com.eventplanner.eventapp.rest;

import com.eventplanner.eventapp.entities.Event;
import com.eventplanner.eventapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EventRestController {
    private EventService eventService;

    @Autowired
    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("events")
    public List<Event> getAllEvents() {
        return this.eventService.getAllEvents();
    }

    @GetMapping("events/{eventId}")
    public Event getEventById(@PathVariable int id) {
        return this.eventService.getEventById(id);
    }

    @PostMapping("events")
    public Event createEvent(@RequestBody Event event) {
        event.setId(0);
        Event newEvent = this.eventService.createEvent(event);
        return newEvent;
    }

    @PutMapping("events")
    public Event updateUser(@RequestBody Event event) {
        Event newUser = this.eventService.updateEvent(event);
        return newUser;
    }

    @DeleteMapping("events/{eventId}")
    public void deleteEvent(@PathVariable int eventId) {
        this.eventService.deleteEvent(eventId);
    }
}
