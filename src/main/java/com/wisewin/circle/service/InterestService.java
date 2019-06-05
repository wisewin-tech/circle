package com.wisewin.circle.service;

import com.wisewin.circle.dao.InterestDAO;
import com.wisewin.circle.dao.InterestSubclassDAO;
import com.wisewin.circle.entity.bo.InterestBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
* 兴趣
* */
@Service("InterestService")
@Transactional
public class InterestService {
    @Resource
    InterestDAO interestDAO;

    @Resource
    InterestSubclassDAO interestSubclassDAO;

    //查询兴趣
    public List<InterestBO> getInterestsByTypeId(Integer interestTypeId){
        return interestDAO.getInterestsByTypeId(interestTypeId);
    }

}
