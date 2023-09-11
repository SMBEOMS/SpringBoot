package com.example.ex04.controller;

import com.example.ex04.domain.ProductVO;
import com.example.ex04.service.ProductService;
import com.example.ex04.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("productForm", new ProductVO());
        model.addAttribute("products", productService.getList());
        return "/product";
    }
    @PostMapping("new")
    @ResponseBody
    public void register(@RequestBody ProductVO productVO){
        productService.register(productVO);
    }

    @GetMapping("{productID}")
    @ResponseBody
    public ProductVO getProduct(@PathVariable("productID") Long productID){
        return productService.getProduct(productID);
    }
}
