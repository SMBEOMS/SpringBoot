package com.example.ex04.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductVO {
    private Long productId;
    private String productName;
    private int productStock;
    private int productPrice;
    private String registerDate;
    private String updateDate;
}
