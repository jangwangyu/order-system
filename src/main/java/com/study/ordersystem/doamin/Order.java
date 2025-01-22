package com.study.ordersystem.doamin;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp OrderAt;

    @MappedCollection(idColumn = "order_item_id", keyColumn = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>(); // OrderItem이 여러개일때

    public Order(int customerId, List<OrderItem> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.OrderAt = Timestamp.valueOf(LocalDateTime.now()); // 객체가 만들어지는 현재 시각
    }

    public static Order newOrder(CreateOrder createOrder) {
        List<OrderItem> items = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : createOrder.getQuantityByProduct().entrySet()) {
            items.add(new OrderItem(entry.getKey(), entry.getValue()));
        }

        return new Order(createOrder.getCustomerId(), items);
    }
}
