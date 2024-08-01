package com.hm.outfit.repository;

import com.hm.outfit.model.ClothingStyle;
import com.hm.outfit.model.Color;
import com.hm.outfit.model.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EventRepositoryTest {
    @Autowired
    private EventRepository eventRepository;

    @Test
    public void testSaveAndEvent() {
        Event event = new Event();
        event.setId("event1");
        event.setName("Birthday Party");
        event.setPreferredStyle(ClothingStyle.CASUAL);
        Set<Color> suitableColors = Set.of(new Color("#FFFFFF", "White", "WHITE"));
        event.setSuitableColors(suitableColors);
        eventRepository.save(event);

        eventRepository.save(event);

        Optional<Event> eventOptional = eventRepository.findById("event1");
        assertTrue(eventOptional.isPresent());
    }
}