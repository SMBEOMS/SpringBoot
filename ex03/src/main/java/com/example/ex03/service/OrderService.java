package com.example.ex03.service;

import com.example.ex03.dao.OrderDAO;
import com.example.ex03.dao.ProductDAO;
import com.example.ex03.domain.OrderDTO;
import com.example.ex03.domain.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;

    //    주문하기
    public void order(OrderVO orderVO) {
        productDAO.setProductStock(orderVO);
        orderDAO.save(orderVO);
    }

    //    주문내역
    public List<OrderDTO> getList(String sort) {
        return orderDAO.findAll(sort);
    }
}
