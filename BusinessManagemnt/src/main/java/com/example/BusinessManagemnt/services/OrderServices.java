package com.example.BusinessManagemnt.services;

import com.example.BusinessManagemnt.entities.Orders;
import com.example.BusinessManagemnt.entities.User;
import com.example.BusinessManagemnt.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    // Get all orders
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    // Save order
    public void saveOrder(Orders order) {
        orderRepository.save(order);
    }

    // Update order
    public void updateOrder(int id, Orders order) {
        Orders existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existing.setoName(order.getoName());
        existing.setoPrice(order.getoPrice());
        existing.setoQuantity(order.getoQuantity());
        existing.setOrderDate(order.getOrderDate());
        existing.setTotalAmount(order.getTotalAmount());
        existing.setUser(order.getUser());

        orderRepository.save(existing);
    }

    // Delete order
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    // Get orders for a user
    public List<Orders> getOrdersForUser(User user) {
        return orderRepository.findByUser(user);
    }
}