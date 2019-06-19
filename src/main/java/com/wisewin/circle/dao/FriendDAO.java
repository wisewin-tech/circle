package com.wisewin.circle.dao;


import com.wisewin.circle.entity.bo.FriendBO;

/**
 * 好友
 * */
public interface FriendDAO {

    //添加好友
    Integer addFriend(FriendBO friendBO);
}
