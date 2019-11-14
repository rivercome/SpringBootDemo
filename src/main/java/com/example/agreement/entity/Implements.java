package com.example.agreement.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * 这种一个类中只包含属性、setter、getter方法，那么这种类就成为简单JavaBean
 */
@EntityScan
public class Implements {
    private Integer companyid;

    private String id;
    private String date;
    private String content;
    private String partya;
    private String partyb;

    public String getId() { return id;}
    public void setId(String id){ this.id =id;}
    public String getDate() {return date;}
    public void setName(String name) {this.date = name;}
    public String getContent() {return content;}
    public void setAge(String age) {this.content = age; }
    public String setPartya() { return partya;}
    public void setPartyb(String partyb) {this.partyb = partyb;}
}
