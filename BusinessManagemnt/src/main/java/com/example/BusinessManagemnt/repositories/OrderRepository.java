package com.example.BusinessManagemnt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BusinessManagemnt.entities.Orders;
import com.example.BusinessManagemnt.entities.User;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByUser(User user);
}