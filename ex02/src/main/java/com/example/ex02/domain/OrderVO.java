package com.example.ex02.domain;

import lombok.Data;

@Data
public class OrderVO {
    private Long orderId;
    private Long productId;
    private int productCount;
    private String orderDate;
}
