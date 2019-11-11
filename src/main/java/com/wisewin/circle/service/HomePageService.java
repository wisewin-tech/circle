package com.wisewin.circle.service;

import com.wisewin.circle.dao.InterestTypeDAO;
import com.wisewin.circle.dao.ModelDAO;
import com.wisewin.circle.dao.UserPictureDAO;
import com.wisewin.circle.entity.bo.InterestType;
import com.wisewin.circle.entity.bo.Model;
import com.wisewin.circle.entity.bo.UserPicture;
import com.wisewin.circle.entity.dto.ModelDTO;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.util.StringUtils;
import com.wisewin.circle.web.controller.HomePageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wang bin
 * @date: Created in 16:00 2019/11/11
 */
@Service
@Transactional
public class HomePageService {

    @Resource
    private InterestTypeDAO interestTypeDAO;
    @Resource
    private ModelDAO modelDAO;
    @Resource
    private UserPictureDAO userPictureDAO;

    private static final Logger log = LoggerFactory.getLogger(HomePageService.class);

    /**
     * 获取主页信息
     * @param model 模式
     * @param userId 用户id
     * @return
     */
    public ResultDTO homepage(String model,Integer userId){
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isEmpty(model)){
          return ResultDTOBuilder.failure("0000001");
        }
        //获取用户基本信息
        Model models = modelDAO.selectModel(model, userId);
        if(org.springframework.util.StringUtils.isEmpty(model)){
            return ResultDTOBuilder.failure("0000004");
        }
        ModelDTO mdto = new ModelDTO();
        mdto.setId(models.getId());
        mdto.setDescribe(models.getDescribe());
        mdto.setSex(models.getSex());
        mdto.setBirthday(models.getBirthplace());
        mdto.setConstellation(models.getConstellation());
        mdto.setHeight(models.getHeight());
        mdto.setEducation(models.getEducation());
        mdto.setBirthplace(models.getBirthplace());
        map.put("model", mdto);
        //获取用户背景图
        List<UserPicture> userPictures = userPictureDAO.selectUserPicture(models.getId());
        log.info("获取用户背景图:{}",userPictures);
        if(!CollectionUtils.isEmpty(userPictures)){
            map.put("userPicture",userPictures) ;
        } else {
            map.put("userPicture","") ;
        }
        //获取系统兴趣
        List<InterestType> interestTypes = interestTypeDAO.selectciInterestType();
        //获取用户自定义兴趣
        List<InterestType> interestTypes2 = interestTypeDAO.selectciUserInterestCustom(models.getId());
        if(!CollectionUtils.isEmpty(interestTypes2)){
            //合并
            interestTypes.addAll(interestTypes);
        }
        map.put("interest", interestTypes);
        //获取用户选中的兴趣
        List<InterestType> interestTypes1 = interestTypeDAO.selectciUserInterest(models.getId());
        if(!CollectionUtils.isEmpty(interestTypes1)){
            map.put("userInterest",interestTypes1) ;
        } else {
            map.put("userInterest","") ;
        }
        return ResultDTOBuilder.success(map);
    }

}
