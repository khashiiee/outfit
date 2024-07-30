package com.hm.outfit.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Container(containerName = "user")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private Gender gender;
    private Size preferredSize;
    private Set<ClothingStyle> preferredStyles;
    private List<String> purchaseHistory;
    private LocalDate birthday;;

    public User(String name, String email, Gender gender, Size preferredSize, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.preferredSize = preferredSize;
        this.birthday = birthday;

    }

    public User(String name, String email, Gender gender, Size preferredSize,Set<ClothingStyle> preferredStyles, List<String> purchaseHistory, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.preferredSize = preferredSize;
        this.preferredStyles = preferredStyles;
        this.purchaseHistory = purchaseHistory;
        this.birthday = birthday;

    }

    public User(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public boolean isChild() {
        return getAge() < 18;
    }

    public String getAgeCategory() {
        if (getAge() < 2) return "baby";
        if (getAge() < 6) return "toddler";
        if (getAge() < 12) return "kids";
        if (getAge() < 18) return "teen";
        return "adult";
    }
}
