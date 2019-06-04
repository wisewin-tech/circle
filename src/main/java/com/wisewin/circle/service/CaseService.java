package com.wisewin.circle.service;

import com.wisewin.circle.common.constants.CaseConstants;
import com.wisewin.circle.dao.CaseDAO;
import com.wisewin.circle.entity.bo.CaseBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//账号认证示例
@Service("CaseService")
@Transactional
public class CaseService {

    @Resource
    CaseDAO caseDAO;

    //随机查询一张示例图片
    public CaseBO getCases(){
        List<CaseBO> caseBOS=caseDAO.getCases(CaseConstants.YES.getValue());
        if(caseBOS.size()==0){
            return null;
        }
        Integer random=(int)(Math.random()*caseBOS.size());
        return caseBOS.get(random);
    }
}
