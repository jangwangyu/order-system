package com.study.ordersystem.doamin;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDto {
    private final String name;
    private final String address;
    private final String phoneNumber;
}
