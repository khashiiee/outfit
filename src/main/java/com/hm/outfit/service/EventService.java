package com.hm.outfit.service;

import com.hm.outfit.exception.custom.EventNotFoundException;
import com.hm.outfit.model.ClothingItem;
import com.hm.outfit.model.ClothingStyle;
import com.hm.outfit.model.Event;
import com.hm.outfit.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getEventById(String eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id: " + eventId));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(String eventId, Event updatedEvent) {
        Event existingEvent = getEventById(eventId);
        // Update event fields here
        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(String eventId) {
        Event event = getEventById(eventId);
        eventRepository.delete(event);
    }

    public List<Event> getEventsByName(String name) {
        return eventRepository.findByName(name);
    }

    public List<Event> getEventsByPreferredStyle(ClothingStyle style) {
        return eventRepository.findByPreferredStyle(style);
    }

    public List<Event> getAllEvents() {
        Iterable<Event> eventsIterable = eventRepository.findAll();
        List<Event> eventsList = new ArrayList<>();
        eventsIterable.forEach(eventsList::add);
        return eventsList;
    }
}
