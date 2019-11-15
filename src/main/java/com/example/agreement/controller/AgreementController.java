package com.example.agreement.controller;

import com.example.agreement.entity.Agreement;
import com.example.agreement.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agreement")
public class AgreementController {
    /**
     * 定义 service
     */
    @Autowired
    private AgreementService service;

    /**
     * 获取所有合同数
     * @return
     */
    @RequestMapping(value = "/getAllAgreement", method = RequestMethod.GET)
    public String getAllAgreement(){
        return service.getAllAgreement();
    }

    /**
     * 获取 合同id
     * @param id 合同id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Agreement getById(@PathVariable int id){
        Agreement agreement = service.getById(id);
        return agreement;
    }

    /**
     * 新增合同
     * @param agreement 合同
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public int addAgre(Agreement agreement){
        int res = service.addAgreement(agreement);
        return res;
    }

    /**
     * 修改合同
     * @param agreement 合同
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public int updateAgre(Agreement agreement){
        System.out.println(agreement.getId());
        int res = 0;
        res = service.updateStu(agreement);
        return res;
    }
}
