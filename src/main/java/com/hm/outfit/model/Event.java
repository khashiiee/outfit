package com.hm.outfit.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "event")
public class Event {
    @Id
    private String id;
    private String name;
    private Set<Color> suitableColors;
    private ClothingStyle preferredStyle;
    private Season season;



}
