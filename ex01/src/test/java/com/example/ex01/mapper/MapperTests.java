package com.example.ex01.mapper;

import com.example.ex01.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired private TimeMapper timeMapper;
    @Autowired private ProductMapper productMapper;

    @Test
    public void getTimeTest(){
        log.info(timeMapper.getTime());
    }

    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("고구마");
        productVO.setProductPrice(3000L);
        productVO.setProductStock(100L);

        productMapper.insert(productVO);
    }

    @Test
    public void selectTest(){
        ProductVO productVO = productMapper.select(2L);
        log.info(productVO.toString());
        assertThat(productVO.getProductPrice()).isEqualTo(1500L);
    }

    @Test
    public void updateTest(){
        ProductVO productVO = productMapper.select(1L);
        productVO.setProductName("고구마");
        productVO.setProductPrice(3000L);

        productMapper.update(productVO);
    }

    @Test
    public void deleteTest() {
        productMapper.delete(1L);
    }

    @Test
    public void selectAllTest(){
        productMapper.selectAll().stream().map(ProductVO::toString).forEach(log::info);
//        assertThat(productMapper.selectAll().get(0).getProductName()).isEqualTo("감자");
        assertThat(productMapper.select(2L)).isIn(productMapper.selectAll());
    }
}










