package com.example.ex04.service;

import com.example.ex04.domain.ProductVO;

import java.util.List;

public interface ProductService {
    //    상품 추가
    public void register(ProductVO productVO);

    //    상품 전체 목록
    public List<ProductVO> getList();

    //    상품 조회
    public ProductVO getProduct(Long productID);
}
