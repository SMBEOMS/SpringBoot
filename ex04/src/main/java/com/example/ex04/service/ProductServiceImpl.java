package com.example.ex04.service;

import com.example.ex04.dao.ProductDAO;
import com.example.ex04.domain.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public void register(ProductVO productVO) {
        productDAO.save(productVO);
    }

    @Override
    public List<ProductVO> getList() {
        return productDAO.findAll();
    }

    @Override
    public ProductVO getProduct(Long productID){
        return ProductDAO.findById(productID);
    }
}













