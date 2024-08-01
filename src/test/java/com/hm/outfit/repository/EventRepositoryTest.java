package com.hm.outfit.repository;

import com.hm.outfit.model.ClothingStyle;
import com.hm.outfit.model.Color;
import com.hm.outfit.model.Event;
import com.hm.outfit.model.Season;
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

        Event event2 = new Event();
        event2.setId("event2");
        event2.setName("Chritsmas Party");
        event2.setPreferredStyle(ClothingStyle.CASUAL);
        Set<Color> suitableColors2 = Set.of(new Color("#FF0000", "Red", "RED"), new Color("#00FF00", "Green", "GREEN"));
        event2.setSeason(Season.WINTER);
        event2.setSuitableColors(suitableColors2);

        eventRepository.save(event2);

    }
}