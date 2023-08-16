package com.example.ex04.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long orderId;
    private Long productId;
    private Long productCount;
    private String orderDate;
}
