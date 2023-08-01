package com.example.ex03.dao;

import com.example.ex03.domain.OrderVO;
import com.example.ex03.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;

    //    주문하기
    public void save(OrderVO orderVO) {
        orderMapper.insert(orderVO);
    }

}
