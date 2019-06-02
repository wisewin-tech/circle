package com.wisewin.circle.service;

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
        List<CaseBO> caseBOS=caseDAO.getCases();
        Integer random=(int)(1+Math.random()*(caseBOS.size()-1+1));
        return caseBOS.get(random-1);
    }
}
