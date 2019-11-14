package com.example.agreement.controller;


import org.springframework.web.bind.annotation.*;


@RestController
public class AcceptParamController {
    @RequestMapping(method = RequestMethod.POST, value = "/hello")
    public String hello(@RequestParam("id") Integer id, @RequestParam("name") String name){
        return "ID:" + id + "NAME" + name;
    }
}
