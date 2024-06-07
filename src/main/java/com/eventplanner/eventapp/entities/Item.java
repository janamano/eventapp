package com.eventplanner.eventapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", name='" + name + '\'' +
                ", covered=" + covered +
                ", coveredBy=" + coveredBy +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event eventId;

    @Column(name = "name")
    private String name;

    @Column(name = "covered")
    private boolean covered;

    @ManyToOne
    @JoinColumn(name = "covered_by", referencedColumnName = "id")
    private User coveredBy;

    public Item() {
    }

    public Item(int id, Event eventId, String name, boolean covered, User coveredBy) {
        this.id = id;
        this.eventId = eventId;
        this.covered = covered;
        this.coveredBy = coveredBy;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public User getCoveredBy() {
        return coveredBy;
    }

    public void setCoveredBy(User coveredBy) {
        this.coveredBy = coveredBy;
    }
}
