package com.example.ex03.controller;

import com.example.ex03.domain.OrderVO;
import com.example.ex03.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order/*")
public class OrderController {
    private final OrderService orderService;

    //    주문
    @PostMapping("done")
    public RedirectView order(OrderVO orderVO){
        log.info(orderVO.getProductCount() + "");
        orderService.order(orderVO);
        return new RedirectView("/product/list");
    }

    @GetMapping("list")
    /*@RequestParam(required = false) : 해당 파라미터 null값 허용*/
    public String list(@RequestParam(required = false) String sort, Model model) {
        if(sort == null) {sort = "recent";}
        model.addAttribute("sort", sort);
        model.addAttribute("orders", orderService.getList(sort));
        return "/order/order-list";
    }
}
