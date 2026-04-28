package com.example.BusinessManagemnt.repositories;

import com.example.BusinessManagemnt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUemail(String email);
}