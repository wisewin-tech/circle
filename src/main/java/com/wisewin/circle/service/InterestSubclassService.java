package com.wisewin.circle.service;

import com.wisewin.circle.dao.InterestSubclassDAO;
import com.wisewin.circle.entity.bo.InterestSubclassBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 二级兴趣
 * */
@Service("InterestSubclassService")
@Transactional
public class InterestSubclassService {

    @Resource
    InterestSubclassDAO interestSubclassDAO;
    /**
     * 通过一级兴趣的id 查询二级兴趣
     * @param interestId 一级兴趣的id
     */
    public List<InterestSubclassBO> getInterestsSubclassByInterestId(Integer interestId){
        return interestSubclassDAO.getInterestsSubclassByInterestId(interestId);
    }
}
