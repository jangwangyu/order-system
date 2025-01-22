package com.study.ordersystem.repository;

import com.study.ordersystem.doamin.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
