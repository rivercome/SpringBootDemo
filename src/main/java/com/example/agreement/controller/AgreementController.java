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
    @RequestMapping(method = RequestMethod.GET, value = "/getAllAgreement")
    public String getAllAgreement(){
        return service.getAllAgreement();
    }

    /**
     * 获取 合同id
     * @param id 合同id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "getById")
    public Agreement getById(int id){
        Agreement agreement = service.getById(id);
        return agreement;
    }

    /**
     * 新增合同
     * @param agreement 合同
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "add")
    public int addAgreement(Agreement agreement){
        int response = service.addAgreement(agreement);
        return response;
    }

    /**
     * 修改合同
     * @param agreement 合同
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public int updateAgreement(Agreement agreement){
        int res = service.updateAgreement(agreement);
        return res;
    }
}
