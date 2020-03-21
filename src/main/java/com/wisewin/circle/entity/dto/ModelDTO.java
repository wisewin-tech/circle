package com.wisewin.circle.entity.dto;

/**
 * @Author: Wang bin
 * @date: Created in 14:42 2019/11/11
 */
public class ModelDTO {
    private Integer id;
    private String model;
    private String describe;
    private String birthday;
    private String constellation;
    private String height;
    private String weight;
    private String education;
    private String birthplace;
    private Integer beLikeCount;
    private Integer beSuperLikeCount;
    private String sex;
    private String name;//昵称
    private Integer sexCount;//性别修改次数
    private String quietStatus;

    public String getQuietStatus() {
        return quietStatus;
    }

    public void setQuietStatus(String quietStatus) {
        this.quietStatus = quietStatus;
    }

    public Integer getSexCount() {
        return sexCount;
    }

    public void setSexCount(Integer sexCount) {
        this.sexCount = sexCount;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    @Override
    public String toString() {
        return "ModelDTO{" +
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
                '}';
    }
}
