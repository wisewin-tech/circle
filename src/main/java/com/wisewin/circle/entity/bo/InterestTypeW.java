package com.wisewin.circle.entity.bo;

import com.wisewin.circle.entity.bo.InterestBO;

import java.util.ArrayList;
import java.util.List;

public class InterestTypeW {

    private Long id;
    private String typeName;
    private List<UserInterestBOV2> interestBOList=new ArrayList<UserInterestBOV2>();
    private List<UserInterestCustomBO> CustomInterestBOList=new ArrayList<UserInterestCustomBO>();//自定义兴趣

    public List<UserInterestCustomBO> getCustomInterestBOList() {
        return CustomInterestBOList;
    }

    public void setCustomInterestBOList(List<UserInterestCustomBO> customInterestBOList) {
        CustomInterestBOList = customInterestBOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserInterestBOV2> getInterestBOList() {
        return interestBOList;
    }

    public void setInterestBOList(List<UserInterestBOV2> interestBOList) {
        this.interestBOList = interestBOList;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
