package com.wisewin.circle.service;

import com.wisewin.circle.dao.MateDAO;
import com.wisewin.circle.entity.bo.UserMsgBO;
import com.wisewin.circle.pop.SystemConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("MateService")
@Transactional
public class MateService {

    @Resource
    private MateDAO mateDAO;
    @Resource
    private UserService userService;

    public List<UserMsgBO> matching(String type, Integer userId){

        //查询用户筛选条件
        Map<String, Object> map = userService.queryCondition(type,userId);
        map.put("userId",userId);
        map.put("type",type);


        List<Integer> like = this.like(map); //喜欢该用户的用户  默认两个
        //回流用户
        List<Integer> backflow=this.backflow(map);
        //按条件查询用户
        int count = Integer.parseInt(SystemConfig.getString("count")); //需要查出用户数量
        int lack=count-like.size()-backflow.size();
        map.put("count",lack);
        List<Integer> userIds = this.queryUserIdCondition(map);
        userIds.addAll(like);
        userIds.addAll(backflow);
        //去重
        deWeight(userIds);

        if(count>userIds.size()){ //数量不够
            map.put("count",count-userIds.size());
            if(userIds.size()>0) {
                map.put("list", userIds);
            }
            List<Integer> ids = this.queryUserIdCondition(map);
            userIds.addAll(ids);
        }
        Collections.shuffle(userIds); //元素随机
        //返回信息

        if(userIds==null || userIds.size()<1){
            return  new ArrayList<UserMsgBO>();
        }
        map.put("list",userIds);
        List<UserMsgBO> userMsgBOS = mateDAO.selectUserMsgByUserIds(map);

        return userMsgBOS;
    }

    /**
     * 喜欢的用户
     * @param queryMap
     * @return
     */
    public List<Integer> like(Map<String,Object>  queryMap){
        String like_sum = SystemConfig.getString("like_sum");
        queryMap.put("count",new Integer(like_sum));
      return mateDAO.queryLikeId(queryMap);
    }


    /**
     * 回流的用户
     * @param map
     * @return
     */
    public List<Integer> backflow(Map<String,Object>  map){
        return  new ArrayList<Integer>();   //TODO 小汶 规则待确定
    }


    /**
     * 按条件匹配用户
     */
    public List<Integer> queryUserIdCondition(Map<String,Object>  map){
        return mateDAO.queryUserIdCondition(map);
    }



   private  void  deWeight(List<Integer>  list){
       Set<Integer> set = new HashSet(list);
       list.clear();
       list.addAll(set);
   }





}
