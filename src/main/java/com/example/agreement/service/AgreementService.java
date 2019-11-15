package com.example.agreement.service;

import com.example.agreement.doa.AgreementDoa;
import com.example.agreement.entity.Agreement;

public interface AgreementService {
    /**
     * 获得所有合同
     * @return
     */

    String getAllAgreement();

    /**
     * 根据id 查找合同
     * @param id 合同id
     * @return
     */

    Agreement getById(int id);

    /**
     * 新增合同
     * @param agreement 合同
     * @return
     */
    int addAgreement(Agreement agreement);

    /**
     * 更新合同
     * @param agreement 合同
     * @return
     */

    int updateAgreement(Agreement agreement);

}
