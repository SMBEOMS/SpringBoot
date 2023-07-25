package com.example.ex02.controller;

import com.example.ex02.domain.ProductVO;
import com.example.ex02.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("productVO", new ProductVO());
        return "/product/product-register";
    }

    @PostMapping("register")
    public RedirectView register(ProductVO productVO){
        productMapper.insert(productVO);
        return new RedirectView("product/list");
    }

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("products", productMapper.selectAll());
        return "/product/product-list";
    }
}
