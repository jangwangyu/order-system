package com.study.ordersystem.doamin;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table (name = "store_Products")
@Builder
public class StoreProduct {
    @Id
    private int storeProductId;

    @Column
    private int storeId;

    @Column
    private int productId;

    @Column
    private int stockQuantity;

    public void adjustStockQuantity(int buyQuantity) {
        if(stockQuantity < buyQuantity) {
            throw new RuntimeException("재고보다 많을 수 없습니다.");
        }
        this.stockQuantity = this.stockQuantity - buyQuantity; // stockQuantity는 buy와 stock을 뺀 것

    }
}
