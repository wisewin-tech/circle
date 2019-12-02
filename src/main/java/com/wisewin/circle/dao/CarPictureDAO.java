package com.wisewin.circle.dao;

import org.apache.ibatis.annotations.Param;

public interface CarPictureDAO {
    //添加车库图片
    Integer addCarPicture(@Param("pictureUrl") String pictureUrl, @Param("userId")Long userId);
}
