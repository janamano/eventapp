package com.eventplanner.eventapp.repos;

import com.eventplanner.eventapp.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i WHERE i.eventId.id = :eventId")
    List<Item> findByEventId(int eventId);
}
