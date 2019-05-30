package com.wisewin.circle.dao;



import com.wisewin.circle.entity.bo.NewbitHelpBO;
import com.wisewin.circle.entity.bo.NewbitHelpContentBO;

import java.util.List;


public interface NewbitHelpDAO {

    /**
     * 查询新手帮助信息
     * @return
     */
    List<NewbitHelpBO> selectNewbitHelp();

    /**
     * 查询新手帮助内容
     * @param id
     * @return
     */
    NewbitHelpContentBO getNewbitHelpContent(Integer id);
}
