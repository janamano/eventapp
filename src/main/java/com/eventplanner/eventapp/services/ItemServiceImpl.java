package com.eventplanner.eventapp.services;

import com.eventplanner.eventapp.entities.Item;
import com.eventplanner.eventapp.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        item.setId(0);
        return this.itemRepository.save(item);
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> itemRes = this.itemRepository.findById(id);
        if (itemRes.isPresent()) {
            return itemRes.get();
        } else {
            return null;
        }
    }

    public List<Item> getItems() {
        return this.itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsByEventId(int eventId) {
        return itemRepository.findByEventId(eventId);
    }


    @Override
    public Item updateItem(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
        this.itemRepository.deleteById(id);
    }
}
