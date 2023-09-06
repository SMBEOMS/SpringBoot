package com.example.ex04.dao;

import com.example.ex04.domain.OrderVO;
import com.example.ex04.domain.ProductVO;
import com.example.ex04.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    public static ProductVO findById(Long productID) {
    }

    //    상품 추가
    public void save(ProductVO productVO){
        productMapper.insert(productVO);
    }

    //    상품 전체 목록
    public List<ProductVO> findAll(){
        return productMapper.selectAll();
    }
    //    상품 재고 수정
    public void setProductStock(OrderVO orderVO){
        productMapper.updateStock(orderVO);
    }
    //    상품 조회
    public ProductVO findByID(Long productID){
        return productMapper.select(productID);
    }

}



















