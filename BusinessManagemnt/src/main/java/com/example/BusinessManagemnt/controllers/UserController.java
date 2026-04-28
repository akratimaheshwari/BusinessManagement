package com.example.BusinessManagemnt.controllers;

import com.example.BusinessManagemnt.entities.User;
import com.example.BusinessManagemnt.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserServices services;

    @PostMapping("/addingUser")
    public String addUser(@ModelAttribute User user) {
        System.out.println(user);
        services.addUser(user);
        return "redirect:/admin/services";
    }

    @GetMapping("/updatingUser/{id}")
    public String updateUser(@ModelAttribute User user,
                             @PathVariable("id") int id) {

        services.updateUser(user, id);
        return "redirect:/admin/services";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        services.deleteUser(id);
        return "redirect:/admin/services";
    }
}