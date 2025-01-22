package com.study.ordersystem.repository;

import com.study.ordersystem.doamin.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
