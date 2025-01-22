package com.study.ordersystem.doamin;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int storeId;
    private int customerId;
    private Map<Integer, Integer> quantityByProduct; // ["아이스 아메리카노", 3] 상품별 갯수


}
