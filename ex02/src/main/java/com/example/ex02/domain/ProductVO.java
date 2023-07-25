package com.example.ex02.domain;

import lombok.Data;

@Data
public class ProductVO {
    private Long productId;
    private String productName;
    private int productStock;
    private int productPrice;
    private String registerDate;
    private String updateDate;
}
