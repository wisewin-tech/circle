package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.CarCertificationBO;
import com.wisewin.circle.entity.bo.CarIncidentBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarPictureDAO {
    //添加车图片
    Integer addCarPicture(@Param("cerId") Long cerId, @Param("carPic")String carPic);

    //获取车认证信息
    CarCertificationBO getCarCertificationBO(Long userId);

    //获取车图片
    List<String> getCarPic(Long cerId);
}
