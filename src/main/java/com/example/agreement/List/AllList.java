package com.example.agreement.List;

import com.example.agreement.entity.Agreement;

import java.util.List;

public class AllList {
    private List<Agreement> allList;
    public AllList() {    }

    public List<Agreement> getAllList() {
        return allList;
    }

    public void setAllList(List<Agreement> allList) {
        this.allList = allList;
    }

    @Override
    public String toString() {
        return "AllList{" +
                "allList=" + allList +
                '}';
    }
}
