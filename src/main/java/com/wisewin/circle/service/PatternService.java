package com.wisewin.circle.service;

import com.wisewin.circle.dao.PatternDAO;
import com.wisewin.circle.dao.TestDAO;
import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.PatternBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/2/28.
 */
@Service("PatternService")
@Transactional
public class PatternService {
    @Resource
    private PatternDAO patternDAO;

    //修改模式信息
    public boolean updatePattern(PatternBO patternBO){
        return patternDAO.updatePattern(patternBO)>0;
    }
}
