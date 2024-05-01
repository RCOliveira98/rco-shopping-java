package com.rcoshopping.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoshopping.ecommerce.entities.OrderEntity;
import com.rcoshopping.ecommerce.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> findAll() {
        return this.orderRepository.findAll();
    }

    public OrderEntity findById(Long id) {
        Optional<OrderEntity> order = this.orderRepository.findById(id);
        return order.get();
    }

    public OrderEntity insert(OrderEntity orderEntity) {
        return this.orderRepository.save(orderEntity);
    }
}
