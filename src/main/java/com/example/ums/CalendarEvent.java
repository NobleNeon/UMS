package com.example.ums;

import java.time.LocalDateTime;

public class CalendarEvent {
    private LocalDateTime date;
    private String eventName;
    private String location;

    public CalendarEvent(LocalDateTime date, String eventName, String location) {
        this.date = date;
        this.eventName = eventName;
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Calender Activity: " + " Date/Time = " + date + " Event Name = " + eventName + " Location = " + location;
    }
}