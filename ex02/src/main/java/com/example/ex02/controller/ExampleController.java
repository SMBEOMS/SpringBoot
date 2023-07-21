package com.example.ex02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.ex02.domain.MemberVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public void ex01(){
        log.info("====================ex01====================");
    }
    @GetMapping("ex02")
    public void ex02(HttpServletRequest request){
        log.info(request.getParameter("name"));
    }
    @GetMapping("ex03")
    public void ex03(String name){ //키값이 매개변수랑 같아야한다 name = name
        log.info(name);
    }
    @GetMapping("ex04")
    public void ex04(MemberVO memberVO){
        log.info("member: " + memberVO.toString());
    }
    @GetMapping("ex05")
    public void ex05(@RequestParam("id") String name, int age) {
        log.info("name:" + name);
        log.info("age:" + age);
    }
    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, String id) { //객체(MemberVO) 필드(memberVO) 매개변수,파라미터(String id)
        log.info("member name: " + memberVO.getName());
        log.info("age: " + memberVO.getAge());
        log.info("name: " + id);
    }
    @GetMapping("ex07")
    public void ex07(){
    }
    @GetMapping("ex08")
    public String  ex08(){
        return "ex/ex08/ex08";
    }
    @GetMapping("ex09")
    public String ex09(String name, Model model/*, HttpServletRequest request*/){
//        request.setAttribute("name", name);
        model.addAttribute("name", name);
        return "ex/ex09";
    }
    @GetMapping("ex10")
    public String ex10(MemberVO memberVO){
        return "ex10";
    }
    @GetMapping("ex11")
    public void ex11(MemberVO memberVO, @ModelAttribute("gender") String gender){

    }
    @GetMapping("ex12")
    public void ex12(@RequestParam("data") List<String> datas) {
        log.info("=================================");
        datas.forEach(log::info);
    }
}
