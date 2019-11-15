package com.example.agreement.entity;

import java.util.List;

public class AgreementExtend {
    private Integer id;
    private Integer contrast_id;
    private String content;
    private String date;
    private String partya;
    private String partyb;
    private String editor;
    private String editime;
    private List<Agreement> orderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContrast_id() {
        return contrast_id;
    }

    public void setContrast_id(Integer contrast_id) {
        this.contrast_id = contrast_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPartya() {
        return partya;
    }

    public void setPartya(String partya) {
        this.partya = partya;
    }

    public String getPartyb() {
        return partyb;
    }

    public void setPartyb(String partyb) {
        this.partyb = partyb;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEditime() {
        return editime;
    }

    public void setEditime(String editime) {
        this.editime = editime;
    }

    public List<Agreement> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Agreement> orderList) {
        this.orderList = orderList;
    }
}
