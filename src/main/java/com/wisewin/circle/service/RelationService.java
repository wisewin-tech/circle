package com.wisewin.circle.service;

import com.wisewin.circle.common.constants.FriendConstants;
import com.wisewin.circle.dao.FriendDAO;
import com.wisewin.circle.dao.RelationDAO;

import com.wisewin.circle.entity.bo.FriendBO;
import com.wisewin.circle.entity.bo.RelationBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 关系
 */
@Service("RelationService")
@Transactional
public class RelationService {
    @Resource
    private RelationDAO relationDAO;

    @Resource
    private FriendDAO friendDAO;

    /**
     * 用户点击喜欢 或者不喜欢
     * */
    public boolean addRelation(RelationBO relationBO){
        //keyvalue取出来 滑动次数
        //滑动一次存redis
        //判断每天是否还有滑动次数

        //判断对方是否喜欢过自己 喜欢过则加好友
        if(relationDAO.checkUserLike(relationBO.getUserIdMain(),relationBO.getUserId())>0){
            FriendBO  friendBO=new FriendBO();
            friendBO.setUid(relationBO.getUserId());
            friendBO.setBid(relationBO.getUserIdMain());
            friendBO.setPattern(relationBO.getType());
            friendBO.setType(FriendConstants.DEFAULT.getValue());
            friendDAO.addFriend(friendBO);
        }
        return relationDAO.addRelation(relationBO)>0;
    }

}
