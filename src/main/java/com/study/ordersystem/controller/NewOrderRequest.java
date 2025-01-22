package com.study.ordersystem.controller;

import lombok.Getter;

import java.util.Map;

@Getter
public class NewOrderRequest {
    private final Integer CustomerId;
    private final Integer storeId;
    private final Map<Integer, Integer> products;

    public NewOrderRequest(Integer CustomerId, Integer storeId, Map<Integer, Integer> products) {
        this.CustomerId = CustomerId;
        this.storeId = storeId;
        this.products = products;
    }
}
