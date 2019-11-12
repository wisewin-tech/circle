package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.CarIncidentBO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CarIncidentDAO {
    /**
     * 兜风模式添加事件
     * @param carIncidentBO
     */
    void addCarIncident(CarIncidentBO carIncidentBO);

    /**
     * 查询用户兜风事件个数
     * @param userId
     * @return
     */
    int selectIncidentNumByUserId(int userId);

    /**
     * 取消兜风事件
     * @param userId
     * @param status
     */
    void cancelCarIncident(@Param("userId")Integer userId,@Param("status")String status);

}
