package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.Item;

import java.util.List;

public interface ItemService {
    public Item createItem(Item item);

    public List<Item> getItems();

    public Item getItemById(int id);

    List<Item> getItemsByEventId(int eventId);
    public Item updateItem(Item item);

    public void deleteItem(int id);
}
