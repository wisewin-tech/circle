package com.wisewin.circle.entity.dto.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: Wang bin
 * @date: Created in 13:34 2019/11/11
 */
public class ModelParam {
    private Integer id;
    private String model;
    private String describe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String constellation;
    private String height;
    private String weight;
    private String education;
    private String birthplace;
    private Integer beLikeCount;
    private Integer beSuperLikeCount;
    private String sex;
    private Integer userId;
    private String name;
    private Integer sexCount;
    private String interestBOList;
    private String customInterestBOList;
    private String userPictureList;//背景图json
    private String headPic;//头像

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getUserPictureList() {
        return userPictureList;
    }

    public void setUserPictureList(String userPictureList) {
        this.userPictureList = userPictureList;
    }

    public Integer getSexCount() {
        return sexCount;
    }

    public void setSexCount(Integer sexCount) {
        this.sexCount = sexCount;
    }

    public String getInterestBOList() {
        return interestBOList;
    }

    public void setInterestBOList(String interestBOList) {
        this.interestBOList = interestBOList;
    }

    public String getCustomInterestBOList() {
        return customInterestBOList;
    }

    public void setCustomInterestBOList(String customInterestBOList) {
        this.customInterestBOList = customInterestBOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getBeLikeCount() {
        return beLikeCount;
    }

    public void setBeLikeCount(Integer beLikeCount) {
        this.beLikeCount = beLikeCount;
    }

    public Integer getBeSuperLikeCount() {
        return beSuperLikeCount;
    }

    public void setBeSuperLikeCount(Integer beSuperLikeCount) {
        this.beSuperLikeCount = beSuperLikeCount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ModelParam{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", describe='" + describe + '\'' +
                ", birthday='" + birthday + '\'' +
                ", constellation='" + constellation + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", education='" + education + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", beLikeCount=" + beLikeCount +
                ", beSuperLikeCount=" + beSuperLikeCount +
                ", sex='" + sex + '\'' +
                ", userId=" + userId +
                '}';
    }
}
