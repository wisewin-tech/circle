package com.wisewin.circle.service;

import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.MateDAO;
import com.wisewin.circle.entity.bo.IncidentMsgBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.bo.UserMSgInterest;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ConditionDTO;
import com.wisewin.circle.pop.Constant;
import com.wisewin.circle.pop.SystemConfig;
import com.wisewin.circle.util.DateUtils;
import com.wisewin.circle.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("MateService")
@Transactional
public class MateService {

    @Resource
    private MateDAO mateDAO;

    public  List<UserMsgBO>  matching(String model, UserBO user,Map<String,Object> search) {
        //查询用户筛选项
        Set<Long> resultSet = new HashSet<Long>();

        search.put("num",10-resultSet.size());
        //查询用户
        if(resultSet.size()<10){
            if(model.equals(UserConstants.CAR.getValue())){
                List<Long> carIds = mateDAO.queryCarUser(search);
                resultSet.addAll(carIds);
            }else{
                List<Long> otherIds = mateDAO.queryOtherUser(search);
                resultSet.addAll(otherIds);
            }
        }
        //更新匹配记录
        updateArise(resultSet,model,user.getId());
        //转化为用户信息
        if(resultSet.size()<1){
            //没有满足条件的用户了
            return new ArrayList<UserMsgBO>();
        }

        List<UserMsgBO> userMsg = getUserMsg(resultSet, model, (String) search.get("place"), (String) search.get("driver"));
        return userMsg;
    }


    /**
     *  查询3个用户
     */
     public List<Long>  getRobot(Map<String,Object> search){
         search.put("num",3);
         return  mateDAO.queryRobot(search);
     }




    /**
     * 喜欢的用户
     *
     * @param queryMap
     * @return
     */
    public List<Integer> like(Map<String, Object> queryMap) {
        String like_sum = SystemConfig.getString("like_sum");
        queryMap.put("count", new Integer(like_sum));
        return null;//mateDAO.queryLikeId(queryMap);
    }





    /**
     *   查询用户 筛选条件
     * @param userId 用户id
     * @param model 模式
     * @return ageStart 开始查询年龄
     *         ageEnd   查询结束年龄
     *         sex 查询性别
     *         dist 查询距离
     *         place 自己的位置
     *         auth 是否真实认证
     *         carAuth 车辆认证
     *         sex 自己的性别
     *         model 模式
     *         driver 司机AND乘客
     *         join  匹配过的用户`
     *         *
     */
    public Map<String,Object> userCondition(Long userId, String model){
        Map<String,Object>  map=new HashMap<String, Object>();
        ConditionDTO conditionDTO = mateDAO.userCondition(userId, model);
        //年龄
        String[] age = conditionDTO.getSearchAge().split("-");
        map.put("ageEnd", DateUtils.getStartDate(Integer.parseInt(age[0])));
        map.put("ageStart",DateUtils.getStartDate(Integer.parseInt(age[1])));
        //性别
        if("friend".equals(model) &&  conditionDTO.getSex().equals("女")){
            map.put("searchSex",conditionDTO.getSex());
        }else{
            map.put("searchSex",conditionDTO.getSearchSex());
        }
        //搜索距离 千米转为米
        map.put("dist",Integer.parseInt(conditionDTO.getSearchDistance())*1000);
        //自己的位置
        map.put("place",conditionDTO.getWhereIs());
        //真实认证开关
        map.put("auth",conditionDTO.getSexStatus());
        //车辆认证开关
        map.put("carAuth",conditionDTO.getCarCertificationStatus());
        //自己的性别
        map.put("model",model);
        //司机/乘客
        map.put("driver",conditionDTO.getDriver());
        //用户id
        map.put("userId",userId);
        map.put("index",userId.hashCode());

        return map;
    }


    /**
     * 修改用户的匹配记录
     */
    public  void updateArise(Long id,String model,Long userId,Integer index){
        Map<String,Object>  paramMap=new HashMap<String, Object>();
        paramMap.put("userId",userId);
        paramMap.put("model",model);
        paramMap.put("id",id);
        paramMap.put("index",index);
        mateDAO.updateArise(paramMap);
    }

    public  void updateArise(Set<Long> ids, String model, Long userId) {
        if(ids!=null && ids.size()>0) {
            for (Long id : ids) {
                updateArise(id,model,userId,userId.hashCode());
            }
        }

    }

    /**
     * 用户信息
     */
     public List<UserMsgBO> getUserMsg(Set<Long> ids,String model,String location,String driver){
         Map<String,Object> paramMap=new HashMap<String, Object>();
         paramMap.put("ids",ids);
         paramMap.put("model",model);
         paramMap.put("location",location);
         List<UserMsgBO> userMsgBOS=mateDAO.getUserMsg(paramMap);
        if(userMsgBOS!=null && userMsgBOS.size()>1){
            Iterator<UserMsgBO> iterator = userMsgBOS.iterator();
            while (iterator.hasNext()){
                UserMsgBO next = iterator.next();
                //图片
                List<String> pricture = mateDAO.queyrPicture(next.getModelId());
                //如果图片全部审核失败,不展示改用户
                if(pricture==null || pricture.size()<1){
                    iterator.remove();
                    continue;
                }
                next.setPicture(pricture);
                //兴趣
                List<UserMSgInterest> userMSgInterests = mateDAO.queryInterest(next.getModelId());
                next.setInterest(userMSgInterests);

                //事件 是car模式并且是司机
                if(UserConstants.Yes.getValue().equals(driver) && UserConstants.CAR.getValue().equals(model)){
                    IncidentMsgBO incidentMsgBO = mateDAO.queryIncident(next.getId());
                    next.setIncident(incidentMsgBO);
                }
            }
        }
         return userMsgBOS;
     }


}