package com.study.ordersystem.controller;

import com.study.ordersystem.doamin.CreateCustomer;
import com.study.ordersystem.doamin.CustomerDto;
import com.study.ordersystem.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService; // 생성자 주입

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Response<CustomerDto> createNewCustomer(@RequestParam String name,
                                                   @RequestParam String address,
                                                   @RequestParam String phoneNumber) {
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder()
                        .address(address)
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .build())
        );
    }
}
