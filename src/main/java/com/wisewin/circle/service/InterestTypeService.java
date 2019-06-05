package com.wisewin.circle.service;

import com.wisewin.circle.dao.InterestDAO;
import com.wisewin.circle.dao.InterestSubclassDAO;
import com.wisewin.circle.dao.InterestTypeDAO;
import com.wisewin.circle.entity.bo.InterestTypeBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 兴趣分类
 * */
@Service("InterestTypeService")
@Transactional
public class InterestTypeService {

    @Resource
    InterestTypeDAO interestTypeDAO;

    /**
     * 通过一级兴趣的id 查询二级兴趣
     */
    public List<InterestTypeBO> getInterestsType(){
        return interestTypeDAO.getInterestsType();
    }
}
