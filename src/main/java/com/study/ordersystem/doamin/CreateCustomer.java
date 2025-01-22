package com.study.ordersystem.doamin;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCustomer {
    private final String name;
    private final String phoneNumber;
    private final String address;
}
