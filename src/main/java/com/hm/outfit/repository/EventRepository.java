package com.hm.outfit.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.hm.outfit.model.ClothingStyle;
import com.hm.outfit.model.Color;
import com.hm.outfit.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends CosmosRepository<Event, String> {
    List<Event> findByName(String name);
    List<Event> findByPreferredStyle(ClothingStyle style);
    List<Event> findBySuitableColorsContaining(Set<Color> colors);

}
