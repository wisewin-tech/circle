package com.wisewin.circle.entity.bo;

public class TheGarageBO {
    private Integer id; //车库
    private Integer userId; //用户id
    private String plateNumber; //车牌号
    private String brandModel; //品牌型号
    private String headingCode;  //车辆识别码
    private String certificationPictures; //认证图片
    private String status; //认证状态


    public TheGarageBO(Integer userId, String plateNumber, String brandModel, String headingCode, String certificationPictures, String status) {
        this.userId = userId;
        this.plateNumber = plateNumber;
        this.brandModel = brandModel;
        this.headingCode = headingCode;
        this.certificationPictures = certificationPictures;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TheGarageBO{" +
                "id=" + id +
                ", userId=" + userId +
                ", plateNumber='" + plateNumber + '\'' +
                ", brandModel='" + brandModel + '\'' +
                ", certificationPictures='" + certificationPictures + '\'' +
                ", status=" + status +
                '}';
    }

    public String getHeadingCode() {
        return headingCode;
    }

    public void setHeadingCode(String headingCode) {
        this.headingCode = headingCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getCertificationPictures() {
        return certificationPictures;
    }

    public void setCertificationPictures(String certificationPictures) {
        this.certificationPictures = certificationPictures;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
