package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.TheGarageBO;
import org.apache.ibatis.annotations.Param;

/**
 * 车库
 */
public interface TheGarageDAO {

    /**
     * 添加车库认证
     */
    Integer addTheGarage(TheGarageBO theGarageBO);

    /**
     * 查询车库是否存在车牌
     * String plateNumber; //车牌号
     */
    int findTheGarage(@Param("plateNumber")String plateNumber);

    /**
     * 查询当前用户是否审核通过或者是否有数据
     */
    int queryTheGarage(@Param("userId")Integer userId);

    /**
     * 通过用户id来查询车库id
     */
    TheGarageBO findIdTheGarage(@Param("id") Integer userId);

}
