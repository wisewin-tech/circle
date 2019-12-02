package com.wisewin.circle.service;

import com.wisewin.circle.dao.ModelDAO;
import com.wisewin.circle.entity.bo.ModelBO;
import com.wisewin.circle.entity.bo.ScreenParamBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("modelService")
@Transactional
public class ModelService {
    @Resource
    private ModelDAO modelDAO;

    /**
     * 初始化用户三个模式资料
     */
    public void addDefault(Long userId,String phone){
        ModelBO modelBO = new ModelBO();
        modelBO.setUserId(userId);
        modelBO.setName(phone+"_用户");//默认用户名
        modelBO.setDescribe("说点什么...");
        modelBO.setSex("男");//默认性别
        modelBO.setSexCount(0);//性别修改次数
        modelBO.setBirthday(new Date());//默认生日
        modelBO.setConstellation("双子座");//默认星座
        modelBO.setHeight(175);//默认身高
        modelBO.setWeight(50);//默认体重
        modelBO.setEducation("大专");//默认学历
        modelBO.setBirthplace("北京-东城");//默认出生地
        modelBO.setSearchDistance("50");//默认搜索距离
        modelBO.setSearchSex("男");//默认搜索性别
        modelBO.setSearchAge("18-25");//默认搜索年龄
        modelBO.setSexStatus("no");//真实性别开关
        modelBO.setCarCertificationStatus("no");//汽车认证开关
        modelBO.setBeLikeCount(0);//被喜欢次数
        modelBO.setBeSuperLikeCount(0);//被超级喜欢次数
        modelBO.setSuperLikeCount(0);//超级喜欢次数
        modelBO.setBeShieldingCount(0);//被屏蔽次数
        modelBO.setModel("date");//添加一个默认模式为异性模式
        modelDAO.addDefault(modelBO);
//        String[] models = new String[]{"car","date","friend"};
//        for (int i=0;i<models.length;i++) {
//
//        }

    }

    /**
     * 修改用户筛选条件
     * @param userId 用户id
     * @param model 模式名称
     * @param searchDistance 搜索距离
     * @param searchAge 搜索性别
     * @param searchSex 搜索年龄
     * @param sexStatus 真实性认证
     * @param carCertificationStatus 车辆认证状态
     */
    public void updateScreen(Long userId,String model,String searchDistance,String searchAge,String searchSex,String sexStatus,String carCertificationStatus){
        ScreenParamBO screenParamBO = new ScreenParamBO();
        screenParamBO.setUserId(userId);
        screenParamBO.setModel(model);
        screenParamBO.setSearchDistance(searchDistance);
        screenParamBO.setSearchAge(searchAge);
        screenParamBO.setSearchSex(searchSex);
        screenParamBO.setSexStatus(sexStatus);
        screenParamBO.setCarCertificationStatus(carCertificationStatus);
        modelDAO.updateScreen(screenParamBO);
    }

    /**
     * 查询筛选条件
     * @param model
     * @param userId
     * @return
     */
    public ScreenParamBO selectScreen(String model, Long userId){
        return modelDAO.selectScreen(model,userId);
    }

}
