package com.example.BusinessManagemnt.services;

import com.example.BusinessManagemnt.entities.User;
import com.example.BusinessManagemnt.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    public List<User> getAllUser() {
        return userRepository.findAll();  // ✅ no casting
    }

    // Get Single User
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get User By Email
    public User getUserByEmail(String email) {
        return userRepository.findByUemail(email);  // ✅ method name fix
    }

    // Update User
    public void updateUser(User user, int id) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUname(user.getUname());
        existing.setUemail(user.getUemail());
        existing.setUpassword(user.getUpassword());
        existing.setUnumber(user.getUnumber());

        userRepository.save(existing);
    }

    // Delete User
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    // Add User
    public void addUser(User user) {
        userRepository.save(user);
    }

    // Validate Login (Optimized)
    public boolean validateLoginCredentials(String email, String password) {
        User user = userRepository.findByUemail(email);
        return user != null && user.getUpassword().equals(password);
    }
}