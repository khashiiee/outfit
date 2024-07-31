package com.hm.outfit.service;


import com.hm.outfit.exception.custom.UserNotFoundException;
import com.hm.outfit.model.ClothingItem;
import com.hm.outfit.model.User;
import com.hm.outfit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userId, User updatedUser) {
        User existingUser = getUserById(userId);
        // Update user fields here
        return userRepository.save(existingUser);
    }

    public void deleteUser(String userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be null for update operation");
        }

        // Check if the user exists
        userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + user.getId()));

        // If the user exists, save the updated user
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        Iterable<User> itemsIterable = userRepository.findAll();
        List<User> itemsList = new ArrayList<>();
        itemsIterable.forEach(itemsList::add);
        return itemsList;
    }
}