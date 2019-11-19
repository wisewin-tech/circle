package com.wisewin.circle.service;

import com.wisewin.circle.dao.MatchingFriendedDAO;
import com.wisewin.circle.dao.MathchingDAO;
import com.wisewin.circle.dao.ModelDAO;
import com.wisewin.circle.entity.bo.Matching;
import com.wisewin.circle.entity.bo.MatchingFriended;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Wang bin
 * @date: Created in 13:54 2019/11/19
 */
@Service
public class MatchingService {


    @Resource
    private MathchingDAO mathchingDAO;
    @Resource
    private MatchingFriendedDAO matchingFriendedDAO;
    @Resource
    private ModelDAO modelDAO;

    /**
     * 汽车模式匹配
     * @return
     */
    public ResultDTO carMatching(Matching matching){
        //like:喜欢；noLike:不喜欢；superLike:超级喜欢；shielding:屏蔽；
        if("like".equals(matching.getOperationStatus()) || "superLike".equals(matching.getOperationStatus())){
            //判断foruser是否喜欢过用户
            int i = mathchingDAO.selectCountCar(matching.getForUser(), matching.getUserId());
            if(i > 0){
                //喜欢过
                MatchingFriended matchingFriended = new MatchingFriended();
                matchingFriended.setUserId(matching.getUserId());
                matchingFriended.setFriendsId(matching.getForUser());
                matchingFriended.setModel("car");
                matchingFriended.setRemark("");
                matchingFriendedDAO.inserMatchingFriended(matchingFriended);
            }
            //没有喜欢过
            mathchingDAO.insertMatchingCar(matching);
            //foruser被喜欢次数+1
            if("like".equals(matching.getOperationStatus())){
                modelDAO.updateLikeCount(matching.getForUser()+"");
            }else {
                //被超级喜欢次数加一
                modelDAO.updateSuperLikeCount(matching.getForUser()+"");
            }
            return ResultDTOBuilder.success("","1000000");

        }

        if("noLike".equals(matching.getOperationStatus())){
            //插入记录
            mathchingDAO.insertMatchingCar(matching);
            return ResultDTOBuilder.success("","1000000");
        }

        if("shielding".equals(matching.getOperationStatus())){
            //插入记录
            mathchingDAO.insertMatchingCar(matching);
            //foruser被屏蔽次数加一
            modelDAO.updateshieldingCount(matching.getForUser()+"");
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 同性模式
     * @return
     */
    public ResultDTO friendMatching(Matching matching){
        //like:喜欢；noLike:不喜欢；superLike:超级喜欢；shielding:屏蔽；
        if("like".equals(matching.getOperationStatus()) || "superLike".equals(matching.getOperationStatus())){
            //判断foruser是否喜欢过用户
            int i = mathchingDAO.selectCountFriend(matching.getForUser(), matching.getUserId());
            if(i > 0){
                //喜欢过
                MatchingFriended matchingFriended = new MatchingFriended();
                matchingFriended.setUserId(matching.getUserId());
                matchingFriended.setFriendsId(matching.getForUser());
                matchingFriended.setModel("friend");
                matchingFriended.setRemark("");
                matchingFriendedDAO.inserMatchingFriended(matchingFriended);
            }
            //没有喜欢过
            mathchingDAO.insertMatchingFriend(matching);
            //foruser被喜欢次数+1
            if("like".equals(matching.getOperationStatus())){
                modelDAO.updateLikeCount(matching.getForUser()+"");
            }else {
                //被超级喜欢次数加一
                modelDAO.updateSuperLikeCount(matching.getForUser()+"");
            }
            return ResultDTOBuilder.success("","1000000");

        }

        if("noLike".equals(matching.getOperationStatus())){
            //插入记录
            mathchingDAO.insertMatchingDate(matching);
            return ResultDTOBuilder.success("","1000000");
        }

        if("shielding".equals(matching.getOperationStatus())){
            //插入记录
            mathchingDAO.insertMatchingDate(matching);
            //foruser被屏蔽次数加一
            modelDAO.updateshieldingCount(matching.getForUser()+"");
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 异性模式
     * @return
     */
    public ResultDTO dateMatching(Matching matching){
        //like:喜欢；noLike:不喜欢；superLike:超级喜欢；shielding:屏蔽；
        if("like".equals(matching.getOperationStatus()) || "superLike".equals(matching.getOperationStatus())){
            //判断foruser是否喜欢过用户
            int i = mathchingDAO.selectCountDate(matching.getForUser(), matching.getUserId());
            if(i > 0){
                //喜欢过
                MatchingFriended matchingFriended = new MatchingFriended();
                matchingFriended.setUserId(matching.getUserId());
                matchingFriended.setFriendsId(matching.getForUser());
                matchingFriended.setModel("date");
                matchingFriended.setRemark("");
                matchingFriendedDAO.inserMatchingFriended(matchingFriended);
            }
            //没有喜欢过
            mathchingDAO.insertMatchingDate(matching);
            //foruser被喜欢次数+1
            if("like".equals(matching.getOperationStatus())){
                modelDAO.updateLikeCount(matching.getForUser()+"");
            }else {
                //被超级喜欢次数加一
                modelDAO.updateSuperLikeCount(matching.getForUser()+"");
            }
            return ResultDTOBuilder.success("","1000000");

        }

        if("noLike".equals(matching.getOperationStatus())){
            //插入记录
            mathchingDAO.insertMatchingDate(matching);
            return ResultDTOBuilder.success("","1000000");
        }

        if("shielding".equals(matching.getOperationStatus())){
            //插入记录
            mathchingDAO.insertMatchingDate(matching);
            //foruser被屏蔽次数加一
            modelDAO.updateshieldingCount(matching.getForUser()+"");
            return ResultDTOBuilder.success("","1000000");
        }
        return ResultDTOBuilder.failure("1111111");
    }
}
