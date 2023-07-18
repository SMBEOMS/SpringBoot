package com.example.ex01.mapper;

import com.example.ex01.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    //    상품 추가
    public void insert(ProductVO productVO);
    //    상품 조회
    @Select("SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_STOCK, PRODUCT_PRICE, REGISTER_DATE, UPDATE_DATE FROM TBL_PRODUCT WHERE PRODUCT_ID = #{productId}")
    public ProductVO select(Long productId);

    //    상품 수정
    public void update(ProductVO productVO);

    //    상품 삭제
    public void delete(Long productId);

    //    상품 전체 조회
    public List<ProductVO> selectAll();
}
