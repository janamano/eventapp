package com.eventplanner.eventapp.dto;

public class ItemDTO {

    private String name;
    private boolean covered;
    private int eventId;
    private int coveredBy;

    public ItemDTO() {
    }

    public ItemDTO(String name, boolean covered, int eventId, int coveredBy) {
        this.name = name;
        this.covered = covered;
        this.eventId = eventId;
        this.coveredBy = coveredBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getCoveredBy() {
        return coveredBy;
    }

    public void setCoveredBy(int coveredBy) {
        this.coveredBy = coveredBy;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "name='" + name + '\'' +
                ", covered=" + covered +
                ", eventId=" + eventId +
                ", coveredBy=" + coveredBy +
                '}';
    }
}