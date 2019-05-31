package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.TheGarageImgBO;
import org.apache.ibatis.annotations.Param;

/**
 * 我的车库
 */
public interface TheGarageImgDAO {

    /**
     * 添加车库
     */
    Integer addTheGarageImg(TheGarageImgBO theGarageImgBO);
}
