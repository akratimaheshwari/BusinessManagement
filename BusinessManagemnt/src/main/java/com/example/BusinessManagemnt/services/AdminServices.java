package com.example.BusinessManagemnt.services;

import com.example.BusinessManagemnt.entities.Admin;
import com.example.BusinessManagemnt.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    // Get All Admins
    public List<Admin> getAll() {
        return adminRepository.findAll();  // ✅ simplified
    }

    // Get Single Admin
    public Admin getAdmin(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    // Update Admin
    public void update(Admin admin, int id) {
        Admin existing = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        existing.setAdminName(admin.getAdminName());
        existing.setAdminEmail(admin.getAdminEmail());
        existing.setAdminPassword(admin.getAdminPassword());
        existing.setAdminNumber(admin.getAdminNumber());

        adminRepository.save(existing);
    }

    // Delete Admin
    public void delete(int id) {
        adminRepository.deleteById(id);
    }

    // Add Admin
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    // Validate Admin Login
    public boolean validateAdminCredentials(String email, String password) {
        Admin admin = adminRepository.findByAdminEmail(email);
        return admin != null && admin.getAdminPassword().equals(password);
    }
}