package com.study.ordersystem.service;

import com.study.ordersystem.doamin.CreateCustomer;
import com.study.ordersystem.doamin.Customer;
import com.study.ordersystem.doamin.CustomerDto;
import com.study.ordersystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository; // 생성자 주입

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDto newCustomer(CreateCustomer customer) {
        Customer entity = Customer.newCustomer(customer); // createCustomer를 entity에 넣어주면 데이터베이스에 넣어주는 entity에 반환
        Customer saved = customerRepository.save(entity);
        return CustomerDto.builder()
                .address(saved.getAddress())
                .name(saved.getName())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
