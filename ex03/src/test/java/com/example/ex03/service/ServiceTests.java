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
}