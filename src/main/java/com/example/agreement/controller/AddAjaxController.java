package com.example.agreement.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddAjaxController {
    @RequestMapping("/ajax")
    public String add(@RequestParam(value = "", required = true)String q){  // addInfo
        // 接受前端传来的数据


        // 和数据库连接并入库
        return "{code: 0, message: 'success'}";
    }
}
