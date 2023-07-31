package com.example.ex03.service;

import com.example.ex03.domain.ProductVO;

import java.util.List;

public interface ProductService {
    //    상품 추가
    public void register(ProductVO productVO);

    //    상품 전체 목록
    public List<ProductVO> getList();
}
