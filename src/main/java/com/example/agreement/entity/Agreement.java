package com.example.agreement.entity;

public class Agreement {
    private Integer id;
    private String content;
    private  String date;
    private String partya;
    private String partyb;
    private String editor;
    private String editime;
    private Integer Cid;
    public Agreement(){

    }
    public Agreement(Integer id,String content, String date, String partya, String partyb, String editor, String editime, Integer Cid){
        this.id = id;
        this.content = content;
        this.date = date;
        this.partya = partya;
        this.partyb = partyb;
        this.editime = editime;
        this.editor = editor;
        this.Cid = Cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return date;
    }

    public void setSex(String date) {
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

    public Integer getCID() {
        return Cid;
    }
    public void setEditime(String editime) {
        this.editime = editime;
    }

}
