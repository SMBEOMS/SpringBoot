package com.example.ex00.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest @Slf4j
public class ComputerTests {
    @Autowired @Qualifier("desktop")
    Computer desktop;

    @Autowired @Qualifier("laptop")
    Computer laptop;

    @Autowired
    Computer computer;

    @Test
    public void computerTest(){
        log.info(desktop.toString());
        log.info(laptop.toString());
        log.info(computer.toString());
    }
}