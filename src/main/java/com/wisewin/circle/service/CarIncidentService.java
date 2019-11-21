package com.wisewin.circle.service;

import com.wisewin.circle.dao.CarIncidentDAO;
import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.CarIncidentBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service("carIncidentService")
@Transactional
public class CarIncidentService {
    @Resource
    private CarIncidentDAO carIncidentDAO;


    /**
     * 兜风模式添加事件
     * @param userId 用户id
     * @param origin 起点
     * @param destination 终点
     * @param incident 事件
     * @param incidentTime 事件时间
     * @param status 状态
     */
    public void addCarIncident(Long userId, String origin, String destination, String incident, String incidentTime,String status){
        CarIncidentBO carIncidentBO = new CarIncidentBO();
        carIncidentBO.setUserId(userId);
        carIncidentBO.setOrigin(origin);
        carIncidentBO.setDestination(destination);
        carIncidentBO.setIncident(incident);
        carIncidentBO.setIncidentTime(incidentTime);
        carIncidentBO.setIncidentStatus(status);
        carIncidentDAO.addCarIncident(carIncidentBO);
    }

    /**
     * 查询用户兜风事件个数
     * @param userId
     * @return
     */
    public int selectIncidentNumByUserId(Long userId){
        return carIncidentDAO.selectIncidentNumByUserId(userId);
    }

    /**
     * 取消兜风事件
     * @param userId
     * @param status
     */
    public void cancelCarIncident(Long userId,String status){
        carIncidentDAO.cancelCarIncident(userId, status);
    }

}
