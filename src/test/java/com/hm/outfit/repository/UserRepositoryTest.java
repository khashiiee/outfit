package com.hm.outfit.repository;

import com.hm.outfit.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testSaveAndRetrieveUser() {

        User user = new User();
        user.setId("anne123");
        user.setName("Anne");
        user.setEmail("anne@gmail.com");
        user.setGender(Gender.FEMALE);
        user.setBirthday(LocalDate.now().minusYears(24));
        user.setPreferredSize(Size.M);
        Set<ClothingStyle> preferredStyles = Set.of(ClothingStyle.CASUAL);
        user.setPreferredStyles(preferredStyles);

        repository.save(user);
        Optional<User> userOptional = repository.findById("anne123");
        assertTrue(userOptional.isPresent());
//        repository.delete(userOptional.get());
    }

}