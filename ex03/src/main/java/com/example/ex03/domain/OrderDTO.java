package com.example.ex03.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDTO {
    private Long productId;
    private String productName;
    private int productStock;
    private int productPrice;
    private String registerDate;
    private String updateDate;
    private Long orderId;
    private Long productCount;
    private String orderDate;
    private Long orderPrice;
}
