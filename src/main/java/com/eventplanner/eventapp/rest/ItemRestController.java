package com.eventplanner.eventapp.rest;

import com.eventplanner.eventapp.dto.ItemDTO;
import com.eventplanner.eventapp.entities.Event;
import com.eventplanner.eventapp.entities.Item;
import com.eventplanner.eventapp.entities.User;
import com.eventplanner.eventapp.services.EventService;
import com.eventplanner.eventapp.services.EventServiceImpl;
import com.eventplanner.eventapp.services.ItemService;
import com.eventplanner.eventapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ItemRestController {

    private ItemService itemService;
    private UserService userService;
    private EventService eventService;

    @Autowired
    public ItemRestController(ItemService itemService, EventService eventService, UserService userService) {
        this.itemService = itemService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("items")
    public List<Item> getItems() {
        return this.itemService.getItems();
    }

    @GetMapping("items/byEvent/{eventId}")
    public ResponseEntity<List<Item>> getItemsByEventId(@PathVariable int eventId) {
        List<Item> items = itemService.getItemsByEventId(eventId);
        return ResponseEntity.ok(items);
    }

    @PostMapping("items")
    public Item createItem(@RequestBody ItemDTO itemDto) {
//        System.out.println(itemDto);
        // get User and Event from this DTO

        // todo check if user and event exists
        Event event = eventService.getEventById(itemDto.getEventId());
        User coveredByUser = this.userService.findUserById(itemDto.getCoveredBy());

        Item item = new Item(0, event, itemDto.getName(), itemDto.isCovered(), coveredByUser);
        item.setId(0);
        return itemService.createItem(item);

    }
}
