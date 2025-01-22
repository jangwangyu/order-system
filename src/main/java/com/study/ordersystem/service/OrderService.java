package com.study.ordersystem.service;

import com.study.ordersystem.doamin.CreateOrder;
import com.study.ordersystem.doamin.Order;
import com.study.ordersystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void newOrder(CreateOrder createOrder) { // entity
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
    }
}
