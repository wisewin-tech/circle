package com.wisewin.circle.dao;

import com.wisewin.circle.entity.bo.Matching;
import org.apache.ibatis.annotations.Param;
import org.apache.xmlbeans.impl.regex.Match;

/**
 * @Author: Wang bin
 * @date: Created in 14:08 2019/11/19
 */
public interface MathchingDAO {

    int insertMatchingCar(Matching matching);

    int insertMatchingDate(Matching matching);

    int insertMatchingFriend(Matching matching);

    /**
     * 查看同性模式下有没有互相喜欢
     * @param userId
     * @param forUser
     * @return
     */
    int selectCountFriend(@Param("userId")Long userId,@Param("forUser")Long forUser);

    /**
     * 查看异性模式下有没有互相喜欢
     * @param userId
     * @param forUser
     * @return
     */
    int selectCountDate(@Param("userId")Long userId,@Param("forUser")Long forUser);

    /**
     * 查看汽车模式下有没有互相喜欢
     * @param userId
     * @param forUser
     * @return
     */
    int selectCountCar(@Param("userId")Long userId,@Param("forUser")Long forUser);
}
