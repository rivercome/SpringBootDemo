package com.example.agreement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreement")
public class AgreementController {
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("date") String date,
                      @RequestParam("content") String content,
                      @RequestParam("partya") Integer partya,
                      @RequestParam("partyb") Integer partyb

    ){
        return id + date + content + partya + partyb ;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edit")
    public String edit(@RequestParam("content") String content,
                       @RequestParam("editor") String editor,
                       @RequestParam("editime") String editime,
                       @RequestParam("id") Integer id
                       ){
        return  content+editor+editime+id;
    }
}
