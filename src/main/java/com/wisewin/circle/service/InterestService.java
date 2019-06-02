package com.wisewin.circle.service;

import com.wisewin.circle.dao.InterestDAO;
import com.wisewin.circle.dao.InterestSubclassDAO;
import com.wisewin.circle.entity.bo.InterestBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
* 一级兴趣管理
* */
@Service("InterestService")
@Transactional
public class InterestService {
    @Resource
    InterestDAO interestDAO;

    @Resource
    InterestSubclassDAO interestSubclassDAO;

    //查询一级兴趣
    public List<InterestBO> getInterestsByTypeId(Integer interestTypeId){
        return interestDAO.getInterestsByTypeId(interestTypeId);
    }

}
