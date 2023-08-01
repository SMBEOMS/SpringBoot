package com.example.ex03.service;

import com.example.ex03.dao.OrderDAO;
import com.example.ex03.domain.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

//    주문하기
    public void order(OrderVO orderVO) {
        orderDAO.save(orderVO);
    }

}
