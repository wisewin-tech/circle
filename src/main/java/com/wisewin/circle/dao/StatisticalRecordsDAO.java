package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.StatisticalRecords;

public interface StatisticalRecordsDAO {
    //添加用户记录信息
    Integer addStatisticalRecords(StatisticalRecords statisticalRecords);

    //获取当日是否已经有记录
    Integer getStatisticalRecordsCount();

    //修改用户活跃
    Integer updStatisticalRecords(StatisticalRecords statisticalRecords);
}
