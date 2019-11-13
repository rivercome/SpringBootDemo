package com.example.agreement;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class HelloController {
    @RequestMapping(value = "hello")
    public String hello() {
        return "Hello World";
    }
}
