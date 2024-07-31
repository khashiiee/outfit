package com.hm.outfit.cotroller;

import com.hm.outfit.model.Event;
import com.hm.outfit.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getUsers() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }


}
