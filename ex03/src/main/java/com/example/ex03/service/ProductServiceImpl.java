package com.example.ex03.service;

import com.example.ex03.dao.ProductDAO;
import com.example.ex03.domain.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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
}













