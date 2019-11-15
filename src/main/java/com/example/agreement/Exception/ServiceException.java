package com.example.agreement.Exception;

public class ServiceException extends RuntimeException{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ServiceException(Integer id){
        super("该合同不存在！" + id);
    }
}
