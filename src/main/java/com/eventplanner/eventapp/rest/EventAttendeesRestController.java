package com.eventplanner.eventapp.rest;

import com.eventplanner.eventapp.dto.EventAttendeesDTO;
import com.eventplanner.eventapp.entities.Event;
import com.eventplanner.eventapp.entities.EventAttendees;
import com.eventplanner.eventapp.entities.User;
import com.eventplanner.eventapp.repos.EventAttendeesRepository;
import com.eventplanner.eventapp.services.EventAttendeesService;
import com.eventplanner.eventapp.services.EventService;
import com.eventplanner.eventapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EventAttendeesRestController {
    private EventAttendeesService eventAttendeesService;
    private UserService userService;
    private EventService eventService;
    @Autowired
    public EventAttendeesRestController(EventService eventService, UserService userService, EventAttendeesService eventAttendeesService) {
        this.eventAttendeesService = eventAttendeesService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("userEvents/{userId}")
    public List<EventAttendees> getAllByEvents(@PathVariable int userId) {
        return this.eventAttendeesService.getEventAttendeesByUserId(userId);
    }

    @GetMapping("eventUsers/{eventId}")
    public List<User> getAllByUsers(@PathVariable int eventId) {
        return this.eventAttendeesService.getEventAttendeesByEventId(eventId).stream().map(EventAttendees::getUser).toList();
    }

    @PostMapping("eventAttendees")
    public EventAttendees createEventAttendee(@RequestBody EventAttendeesDTO eventAttendeesDTO) {
        // todo check if user and event exists
        Event event = eventService.getEventById(eventAttendeesDTO.getEventId());
        User user = this.userService.findUserById(eventAttendeesDTO.getUserId());

        EventAttendees newEventAttendee = new EventAttendees(event, user, 0);;
        return this.eventAttendeesService.saveEventAttendee(newEventAttendee);
    }
}
