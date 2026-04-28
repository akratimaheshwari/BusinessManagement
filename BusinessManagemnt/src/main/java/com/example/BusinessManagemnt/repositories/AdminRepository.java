package com.example.BusinessManagemnt.repositories;

import com.example.BusinessManagemnt.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByAdminEmail(String email);
}