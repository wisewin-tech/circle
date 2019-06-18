package com.wisewin.circle.service;

import com.wisewin.circle.dao.RelationDAO;
import com.wisewin.circle.dao.TestDAO;
import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.RelationBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 关系
 */
@Service("RelationService")
@Transactional
public class RelationService {
    @Resource
    private RelationDAO relationDAO;

    /**
     * 用户点击喜欢 或者不喜欢
     * */
    public boolean addRelation(RelationBO relationBO){
        return relationDAO.addRelation(relationBO)>0;
    }

}
