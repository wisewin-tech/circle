package com.wisewin.circle.service;

import com.wisewin.circle.dao.*;
import com.wisewin.circle.entity.bo.*;
import com.wisewin.circle.entity.dto.ModelDTO;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.ModelParam;
import com.wisewin.circle.entity.dto.param.UserInterestParam;
import com.wisewin.circle.entity.dto.param.UserPictureParam;
import com.wisewin.circle.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Resource
    private UserInterestCustomDAO userInterestCustomDAO;
    @Resource
    private KeyValDAO keyValDAO;

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
        System.err.println("model"+model+"userId"+userId);
        //获取用户基本信息
        Model models = modelDAO.selectModel(model, userId);
        if(org.springframework.util.StringUtils.isEmpty(model)){
            return ResultDTOBuilder.failure("0000004");
        }
        ModelDTO mdto = new ModelDTO();
        mdto.setId(models.getId());
        mdto.setModel(models.getModel());
        mdto.setDescribe(models.getDescribe());
        mdto.setSex(models.getSex());
        mdto.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(models.getBirthday()));
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
        System.err.println("系统兴趣"+interestTypes);
        //获取用户自定义兴趣
        List<InterestType> interestTypes2 = interestTypeDAO.selectciUserInterestCustom(models.getId());
        System.err.println("用户自定义兴趣"+interestTypes2);
        if(!CollectionUtils.isEmpty(interestTypes2)){
            //合并
            interestTypes.addAll(interestTypes);
        }
        System.err.println("兴趣合并"+interestTypes);
        map.put("interest", interestTypes);
        //获取用户选中的兴趣
        List<InterestType> interestTypes1 = interestTypeDAO.selectciUserInterest(models.getId());
        System.err.println("用户选中的兴趣"+interestTypes1);
        if(!CollectionUtils.isEmpty(interestTypes1)){
            map.put("userInterest",interestTypes1) ;
        } else {
            map.put("userInterest","") ;
        }
        return ResultDTOBuilder.success(map,"1000000");
    }


    /**
     * 修改模式个人信息
     * @param modelParam
     * @return
     */
    public ResultDTO updateModel(ModelParam modelParam){

        Model model = modelDAO.selectModel(modelParam.getModel(), modelParam.getUserId());
        if(org.springframework.util.StringUtils.isEmpty(modelParam)){
            return ResultDTOBuilder.failure("0000001");
        }

        String sexCount = keyValDAO.selectKey("sexCount");
        if(!StringUtils.isNotBlank(modelParam.getSex())){
            if(model.getSexCount() >= Integer.parseInt(sexCount)){
                return ResultDTOBuilder.failure("1111111","不可修改性别");
            }
        }
        int i = modelDAO.updateModel(modelParam);
        if(i > 0 ){
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }



    /**
     * 修改背景图
     * @param userPictureParam
     * @return
     */
    public ResultDTO saveUserPircture(List<UserPictureParam> userPictureParam){
        if(CollectionUtils.isEmpty(userPictureParam)){
            return ResultDTOBuilder.failure("0000001");
        }
        //删除之前背景图
        int i = userPictureDAO.deleteUserPicture(userPictureParam.get(0).getModelId());
        //插入最新背景图
        i = userPictureDAO.insertUserPicture(userPictureParam);
        if(i > 0){
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 修改兴趣
     * @param userInterestParams
     * @return
     */
    public ResultDTO saveUserInterest(List<UserInterestParam> userInterestParams){
        if(CollectionUtils.isEmpty(userInterestParams)){
            return ResultDTOBuilder.failure("0000001");
        }
        //删除之前选中兴趣
        int i = interestTypeDAO.deleteUserInterest(userInterestParams.get(0).getModelId());
        i = interestTypeDAO.insetUserInterest(userInterestParams);
        if(i > 0){
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }


    /**
     * 修改自定义兴趣
     * @param list
     * @return
     */
    public ResultDTO saveUserInterestCustom(List<UserInterestCustom> list){
        if(CollectionUtils.isEmpty(list)){
            return ResultDTOBuilder.failure("0000001");
        }
        int i = userInterestCustomDAO.deleteUserInterestCuston(list.get(0).getModelId());
        i = userInterestCustomDAO.insertUserInterestCuston(list);
        if(i > 0){
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 添加自定义兴趣
     * @param userInterestCustom
     * @return
     */
    public ResultDTO insertUserInterestCustom(UserInterestCustom userInterestCustom){
        if(org.springframework.util.StringUtils.isEmpty(userInterestCustom)){
            return ResultDTOBuilder.failure("0000001");
        }
        List<UserInterestCustom> list = new ArrayList<UserInterestCustom>();
        list.add(userInterestCustom);
        int i = userInterestCustomDAO.insertUserInterestCuston(list);
        if(i > 0){
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 切换模式
     * @param userId
     * @param model
     * @return
     */
    public ResultDTO handoverModel(Integer userId, String model){
        if(userId == null){
            return ResultDTOBuilder.failure("0000001");
        }
        if(StringUtils.isNotBlank(model)){
            return ResultDTOBuilder.failure("0000001");
        }
        //判断是否第一次进入这个模式
        ModelBO i = modelDAO.selectModelCount(userId, model);
        if(i != null){
            //模式开关
            modelDAO.updateModelFirst(i.getId().intValue(), "yes");
        }
        //是第一次进入这个模式将data模式数据插入
        i.setModel(model);
        i.setFirst("no");
        modelDAO.addDefault(i);
        return ResultDTOBuilder.success("","1000000");
    }


}
