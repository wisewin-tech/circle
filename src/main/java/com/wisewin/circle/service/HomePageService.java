package com.wisewin.circle.service;

import com.wisewin.circle.dao.*;

import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.ObjectMapper;
import com.wisewin.circle.entity.bo.InterestTypeW;
import com.wisewin.circle.entity.bo.*;
import com.wisewin.circle.entity.dto.ModelDTO;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.entity.dto.param.ModelParam;
import com.wisewin.circle.entity.dto.param.UserInterestParam;
import com.wisewin.circle.entity.dto.param.UserPictureParam;
import com.alibaba.fastjson.JSON;
import com.wisewin.circle.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
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
    @Resource
    private UserCertificationDAO userCertificationDAO;

    @Resource
    UserInterestDAO userInterestDAO;

    private static final Logger log = LoggerFactory.getLogger(HomePageService.class);

    /**
     * 获取主页信息
     *
     * @param model  模式
     * @param userId 用户id
     * @return
     */
    public ResultDTO homepage(String model, Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();

        System.err.println("model" + model + "userId" + userId);
        //获取用户基本信息
        Model models = modelDAO.selectModel(model, userId);
        if (org.springframework.util.StringUtils.isEmpty(model)) {
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
        mdto.setName(models.getName());
        mdto.setSexCount(models.getSexCount());
        mdto.setHeadPic(models.getHeadPic());

        //添加model信息
        map.put("model", mdto);

        //获取车量认证信息***********8
        List<CarCertificationBO> carCertificationBO=userCertificationDAO.queryCarStatusW(new Long(userId));
        map.put("carCertificationStatus", carCertificationBO);

        //获取用户背景图
        List<UserPicture> userPictures = userPictureDAO.selectUserPicture(models.getId());
        //添加背景图
        List<String> userPictureStrList = new ArrayList<String>();
        for (UserPicture up : userPictures) {
            userPictureStrList.add(up.getPictureUrl());
        }
        map.put("userPicture", userPictureStrList);

        //获取系统兴趣分类
        List<InterestTypeW> interestTypes = interestTypeDAO.selectType();
        //获取用户自定义兴趣
        System.out.println("models.getId()" + models.getId());
        List<UserInterestCustomBO> userInterestCustom = interestTypeDAO.getUserInterestCustom(models.getId());
        for (InterestTypeW it : interestTypes) {
            for (UserInterestCustomBO itc : userInterestCustom) {
                if (it.getId().equals(itc.getTypeId())) {
                    it.getCustomInterestBOList().add(itc);
                }
            }
        }

        //获取系统的兴趣
        List<UserInterestBOV2> InterestBOAll = userInterestDAO.selectInterestAll();
        //获取用户选中的系统兴趣
        List<UserInterestBOV2> userInterestBO = userInterestDAO.selectInterestByPatternId(new Long(models.getId()));
        //进行对比，选中的把系统的兴趣状态修改为yes，然后添加到对应分类当中
        for (UserInterestBOV2 all : InterestBOAll) {
            for (UserInterestBOV2 userInterest : userInterestBO) {
                if (all.getInterestName().equals(userInterest.getInterestName())) {
                    all.setStatus("yes");
                }
            }
            for (InterestTypeW it : interestTypes) {
                if (all.getTypeId().equals(it.getId())) {
                    it.getInterestBOList().add(all);
                }
            }
        }


        //合并
        //interestTypes.addAll(interestTypes);
//            System.err.println("自定义兴趣" + interestTypes);
//            map.put("userInterest", interestTypes);

        //获取用户选中的兴趣
//            List<InterestType> interestTypes1 = interestTypeDAO.selectciUserInterest(models.getId());
//            System.err.println("用户选中的兴趣" + interestTypes1);
//            if (!CollectionUtils.isEmpty(interestTypes1)) {
//                map.put("interest", interestTypes1);
//            } else {
//                map.put("interest", "");
//            }

        map.put("interestTypes", interestTypes);
        return ResultDTOBuilder.success(map, "1000000");
    }

    /**
     * 修改模式个人信息
     * @param modelParam
     * @return
     */
    public ResultDTO updateModel(ModelParam modelParam, String interestBOList, String CustomInterestBOList) throws IOException {
        Model model = modelDAO.selectModel(modelParam.getModel(), modelParam.getUserId());

        //判断性别，性别次数，修改性别
        if (modelParam.getSex() != null && !modelParam.getSex().equals(model.getSex())) {
            String sexCount = keyValDAO.selectKey("sexCount");
            modelParam.setSexCount(1);
            if (model.getSexCount() != null && model.getSexCount() >= Integer.parseInt(sexCount)) {
                return ResultDTOBuilder.failure("1111111", "不可修改性别");
            }
        }

        //修改模式信息
        modelParam.setId(model.getId());
        modelDAO.updateModel(modelParam);

        //解析兴趣JSON
        if (interestBOList != null && !interestBOList.equals("")) {
            List<UserInterestBOV2> userInterestBOV2List = JSON.parseArray(interestBOList, UserInterestBOV2.class);
            //添加模式
            for (UserInterestBOV2 userInterestBOV2 : userInterestBOV2List) {
                userInterestBOV2.setModelId(new Long(modelParam.getId()));
            }
            //删除兴趣
            interestTypeDAO.deleteUserInterest(modelParam.getId());
            //添加兴趣
            if (userInterestBOV2List.size() != 0) {
                interestTypeDAO.insetUserInterestW(userInterestBOV2List);
            }
        }
        //解析兴趣JSON
        if (CustomInterestBOList != null && !CustomInterestBOList.equals("")) {
            List<UserInterestCustomBO> userInterestCustomBOList = JSON.parseArray(CustomInterestBOList, UserInterestCustomBO.class);
            //添加模式
            for (UserInterestCustomBO userInterestCustomBO : userInterestCustomBOList) {
                userInterestCustomBO.setModelId(new Long(modelParam.getId()));
            }
            interestTypeDAO.deleteCustomUserInterest(modelParam.getId());
            if (userInterestCustomBOList.size() != 0) {
                interestTypeDAO.insetCustomUserInterest(userInterestCustomBOList);
            }
        }

        //解析背景图JSON
        String userPicture = modelParam.getUserPictureList();
        if (userPicture != null && !userPicture.equals("")) {
            List<UserPictureParam> userPictureList = JSON.parseArray(userPicture, UserPictureParam.class);

            //添加模式和排序
            int i=1;
            for (UserPictureParam userPictureParam : userPictureList) {
                userPictureParam.setSort(i);
                userPictureParam.setModelId(new Integer(modelParam.getId()));
                i++;
            }

            //删除原来的背景
            userPictureDAO.deleteUserPicture(modelParam.getId());

            //添加新背景图
            if (userPictureList.size() != 0) {
                userPictureDAO.insertUserPicture(userPictureList);
            }
        }

        return ResultDTOBuilder.success("", "1000000");
    }


    /**
     * 修改背景图
     *
     * @param userPictureParam
     * @return
     */
    public ResultDTO saveUserPircture(List<UserPictureParam> userPictureParam) {
        if (CollectionUtils.isEmpty(userPictureParam)) {
            return ResultDTOBuilder.failure("0000001");
        }
        //删除之前背景图
        int i = userPictureDAO.deleteUserPicture(userPictureParam.get(0).getModelId());
        //插入最新背景图
        i = userPictureDAO.insertUserPicture(userPictureParam);
        if (i > 0) {
            return ResultDTOBuilder.success("", "1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 修改兴趣
     *
     * @param userInterestParams
     * @return
     */
    public ResultDTO saveUserInterest(List<UserInterestParam> userInterestParams) {
        if (CollectionUtils.isEmpty(userInterestParams)) {
            return ResultDTOBuilder.failure("0000001");
        }
        //删除之前选中兴趣
        int i = interestTypeDAO.deleteUserInterest(userInterestParams.get(0).getModelId());
        i = interestTypeDAO.insetUserInterest(userInterestParams);
        if (i > 0) {
            return ResultDTOBuilder.success("", "1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }


    /**
     * 修改自定义兴趣
     *
     * @param list
     * @return
     */
    public ResultDTO saveUserInterestCustom(List<UserInterestCustom> list) {
        if (CollectionUtils.isEmpty(list)) {
            return ResultDTOBuilder.failure("0000001");
        }
        int i = userInterestCustomDAO.deleteUserInterestCuston(list.get(0).getModelId());
        i = userInterestCustomDAO.insertUserInterestCuston(list);
        if (i > 0) {
            return ResultDTOBuilder.success("", "1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 添加自定义兴趣
     *
     * @param userInterestCustom
     * @return
     */
    public ResultDTO insertUserInterestCustom(UserInterestCustom userInterestCustom) {
        if (org.springframework.util.StringUtils.isEmpty(userInterestCustom)) {
            return ResultDTOBuilder.failure("0000001");
        }
        List<UserInterestCustom> list = new ArrayList<UserInterestCustom>();
        list.add(userInterestCustom);
        int i = userInterestCustomDAO.insertUserInterestCuston(list);
        if (i > 0) {
            return ResultDTOBuilder.success("", "1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 切换模式
     *
     * @param userId
     * @param model
     * @return
     */
    public ResultDTO handoverModel(Integer userId, String model) {
        if (userId == null) {
            return ResultDTOBuilder.failure("0000001");
        }
        if (StringUtils.isNotBlank(model)) {
            return ResultDTOBuilder.failure("0000001");
        }
        //判断是否第一次进入这个模式
        ModelBO i = modelDAO.selectModelCount(userId, model);
        if (i != null) {
            //模式开关
            modelDAO.updateModelFirst(i.getId().intValue(), "yes");
        }
        //是第一次进入这个模式将data模式数据插入
        i.setModel(model);
        i.setFirst("no");
        modelDAO.addDefault(i);
        return ResultDTOBuilder.success("", "1000000");
    }


}
