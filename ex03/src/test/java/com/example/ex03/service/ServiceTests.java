package com.example.ex03.service;

import com.example.ex03.domain.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ServiceTests {
    @Autowired
    OrderService orderService;

    @Test
    public void orderTest(){
        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(4L);
        orderVO.setProductCount(5L);
        orderService.order(orderVO);
    }
}
