package com.wisewin.circle.service;

import com.wisewin.circle.dao.PatternDAO;
import com.wisewin.circle.entity.bo.PatternBO;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    //获取模式信息
    public PatternBO getPatternBO(String type,Integer id){
        return patternDAO.getPatternBO(type,id);
    }

    //修改兴趣
    public boolean updateInterest(String type,Integer id,String interestJson){
        PatternBO patternBO=new PatternBO();
        patternBO.setUserId(id);
        patternBO.setType(type);
        patternBO.setInterest(interestJson);
        return patternDAO.updatePattern(patternBO)>0;
    }

    //查看兴趣
    public List<String> getInterest(String type,Integer id){
        PatternBO patternBO=patternDAO.getPatternBO(type,id);
        if(patternBO==null){
            return null;
        }
        String interestJson=patternBO.getInterest();
        if(interestJson==null){
            return null;
        }
        JSONArray objar = new JSONArray(interestJson);
        List<String> interestList=(List)objar.toList();
        return  interestList;
    }
}
