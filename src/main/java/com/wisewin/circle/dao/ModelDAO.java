package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.ModelBO;

public interface ModelDAO {

    /**
     * 初始化用户三个模式资料
     * @param modelBO
     */
    void addDefault(ModelBO modelBO);
}
