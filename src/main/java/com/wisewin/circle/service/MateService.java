package com.wisewin.circle.service;

import com.wisewin.circle.common.constants.UserConstants;
import com.wisewin.circle.dao.MateDAO;
import com.wisewin.circle.entity.bo.IncidentMsgBO;
import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.entity.bo.UserMSgInterest;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.entity.dto.ConditionDTO;
import com.wisewin.circle.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("MateService")
@Transactional
public class MateService {

    @Resource
    private MateDAO mateDAO;

    public  List<UserMsgBO>  matching(String model, UserBO user,Map<String,Object> search) {
        //查询用户筛选项
        List<Long> resultList = new ArrayList<Long>();
        //喜欢的用户
        List<Long> like = this.like(search);
        resultList.addAll(like);
        //热度用户
        List<Long> heat = this.heat(search, resultList);
        resultList.addAll(heat);
        List<Long> distance = this.distance(search, resultList, 30 - this.nullCount(resultList));
        resultList.addAll(distance);

        //更新匹配记录
        updateArise(resultList,model,user.getId());
        //转化为用户信息
        if(resultList.size()<1){
            //没有满足条件的用户了
            return new ArrayList<UserMsgBO>();
        }

        //打乱顺序
        Collections.shuffle(resultList);

        List<UserMsgBO> userMsg = getUserMsg(resultList, model, (String) search.get("place"), (String) search.get("driver"));
        return userMsg;
    }


    /**
     *  查询3个用户
     */
     public List<Long>  getRobot(Map<String,Object> search){
         search.put("num",3);
         return mateDAO.queryRobot(search);
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
     * 喜欢的用户
     * @param search
     * @return
     */
    public List<Long> like(Map<String, Object> search) {
        search.put("num",9);
        return mateDAO.queryLike(search);
    }


    /**
     * 热度用户
     */
     public List<Long> heat(Map<String,Object> search,List<Long> ids){
         search.put("num",9);
         search.put("ids",this.nullList(ids));
         search.put("activeTime",DateUtils.lsatTime());
         return mateDAO.heat(search);
     }

    /**
     * 距离近的用户
     */
    public List<Long> distance(Map<String,Object> search,List<Long> ids,int num){
        search.put("num",num);
        search.put("ids",this.nullList(ids));
        search.put("activeTime",DateUtils.lsatTime());
        return mateDAO.distance(search);
    }

    /**
     * 空list返回null 方便map文件
     * @param list
     * @return
     */
    public List<Long> nullList(List<Long> list){
         if(list==null || list.size()<1){
             return null;
         }
         return list;
    }

    /**
     * 空list返回 0 长度
     */
    public  int nullCount(List<Long> list){
        if(list==null || list.size()<1){
            return 0;
        }
        return list.size();
    }

    /**
     * 修改用户的匹配记录
     */
    public  void updateArise(List<Long> ids,String model,Long userId,Integer index){
        Map<String,Object>  paramMap=new HashMap<String, Object>();
        paramMap.put("userId",userId);
        paramMap.put("model",model);
        paramMap.put("ids",ids);
        paramMap.put("index",index);
        mateDAO.updateArise(paramMap);
    }


    public  void updateArise(List<Long> ids, String model, Long userId) {
        if(ids!=null && ids.size()>0) {
                updateArise(ids,model,userId,userId.hashCode());
        }

    }

    /**
     * 用户信息
     */
     public List<UserMsgBO> getUserMsg(List<Long> ids,String model,String location,String driver){
         Map<String,Object> paramMap=new HashMap<String, Object>();
         paramMap.put("ids",ids);
         paramMap.put("model",model);
         paramMap.put("location",location);
         paramMap.put("driver",driver);
         //2.0
         List<UserMsgBO> userMsgBOS=mateDAO.getUserMsg2(paramMap);

      //   List<UserMsgBO> userMsgBOS=mateDAO.getUserMsg(paramMap);
       /* if(userMsgBOS!=null && userMsgBOS.size()>1){
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
        }*/
         return userMsgBOS;
     }


}