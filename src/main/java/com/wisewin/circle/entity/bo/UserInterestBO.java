package com.wisewin.circle.entity.bo;

public class UserInterestBO {
    private Integer id;//用户兴趣id
    private String interestType;//兴趣分类
    private String interestString;//兴趣字符串
    private String jointIdJson;//拼接的id json
    private Integer patternId;//模式id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public String getInterestString() {
        return interestString;
    }

    public void setInterestString(String interestString) {
        this.interestString = interestString;
    }

    public String getJointIdJson() {
        return jointIdJson;
    }

    public void setJointIdJson(String jointIdJson) {
        this.jointIdJson = jointIdJson;
    }

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }
}
