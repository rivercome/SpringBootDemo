package com.example.agreement.service;

import com.example.agreement.doa.AgreementDoa;

public interface AgreementService {
    /**
     * 新增合同
     * @param id
     * @param content
     * @param date
     * @param partya
     * @param partyb
     * @return
     */
    AgreementDoa addAgreement(String id,
                              String content,
                              String date,
                              String partya,
                              String partyb
    );

    /**
     * 根据id更新合同
     * @param content
     * @param editor
     * @param editime
     * @return
     */
    AgreementDoa updateAgreement(String content,
                                 Integer id,
                                 String editor,
                                 String editime
    );

}
