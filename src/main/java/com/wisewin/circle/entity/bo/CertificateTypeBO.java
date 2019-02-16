package com.wisewin.circle.entity.bo;


import com.wisewin.circle.common.base.BaseModel;

public class CertificateTypeBO extends BaseModel{

  private Integer id;
  private String type;
  private Integer status;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
