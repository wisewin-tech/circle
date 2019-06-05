package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.PatternBO;
import org.apache.ibatis.annotations.Param;

//模式 筛选条件 兴趣
public interface PatternDAO {

    //修改模式信息
    Integer updatePattern(PatternBO patternBO);

    //获取模式信息
    PatternBO getPatternBO(@Param("type") String type, @Param("id") Integer id);


}

