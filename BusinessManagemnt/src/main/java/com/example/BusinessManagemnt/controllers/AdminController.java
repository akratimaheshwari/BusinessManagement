package com.example.BusinessManagemnt.controllers;

import com.example.BusinessManagemnt.entities.Admin;
import com.example.BusinessManagemnt.entities.Product;
import com.example.BusinessManagemnt.entities.User;
import com.example.BusinessManagemnt.entities.Orders;

import com.example.BusinessManagemnt.services.AdminServices;
import com.example.BusinessManagemnt.services.ProductServices;
import com.example.BusinessManagemnt.services.UserServices;
import com.example.BusinessManagemnt.services.OrderServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @Autowired
    private ProductServices productServices;

    @Autowired
    private UserServices userServices;

    @Autowired
    private OrderServices orderServices;

    // 👉 Dashboard (Main Admin Page)
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<User> users = userServices.getAllUser();
        List<Admin> admins = adminServices.getAll();
        List<Product> products = productServices.getAllProducts();
        List<Orders> orders = orderServices.getOrders();

        model.addAttribute("users", users);
        model.addAttribute("admins", admins);
        model.addAttribute("products", products);
        model.addAttribute("orders", orders);

        return "Admin_Page";
    }

    // 👉 Add Admin
    @PostMapping("/add")
    public String addAdmin(@ModelAttribute Admin admin) {
        adminServices.addAdmin(admin);
        return "redirect:/admin/dashboard";
    }

    // 👉 Update Admin Page
    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable int id, Model model) {
        Admin admin = adminServices.getAdmin(id);
        model.addAttribute("admin", admin);
        return "Update_Admin";
    }

    // 👉 Update Admin
    @PostMapping("/update/{id}")
    public String updateAdmin(@ModelAttribute Admin admin, @PathVariable int id) {
        adminServices.update(admin, id);
        return "redirect:/admin/dashboard";
    }

    // 👉 Delete Admin
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        adminServices.delete(id);
        return "redirect:/admin/dashboard";
    }
}