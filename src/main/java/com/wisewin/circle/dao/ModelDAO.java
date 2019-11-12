package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.Model;
import com.wisewin.circle.entity.bo.ModelBO;
import com.wisewin.circle.entity.dto.param.ModelParam;
import org.apache.ibatis.annotations.Param;

public interface ModelDAO {

    /**
     * 初始化用户三个模式资料
     * @param modelBO
     */
    void addDefault(ModelBO modelBO);

    /**
     * 查询用户主页信息
     * @param model 模式类型
     * @param userId 用户id
     */
    Model selectModel(@Param("model")String model, @Param("userId")Integer userId);


    /**
     * 修改用户信息
     * @param modelParam
     * @return
     */
    int updateModel(ModelParam modelParam);
}
