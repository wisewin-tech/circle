package com.wisewin.circle.service;

import com.wisewin.circle.dao.KeyValDAO;
import com.wisewin.circle.dao.MatchingFriendedDAO;
import com.wisewin.circle.dao.MathchingDAO;
import com.wisewin.circle.dao.ModelDAO;
import com.wisewin.circle.entity.bo.KeyValuesBO;
import com.wisewin.circle.entity.bo.Matching;
import com.wisewin.circle.entity.bo.MatchingFriended;
import com.wisewin.circle.entity.bo.Model;
import com.wisewin.circle.entity.dto.ResultDTO;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.util.DateUtils;
import org.springframework.stereotype.Service;
import reactor.rx.action.error.FallbackAction;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @Resource
    private KeyValDAO keyValDAO;






    /**
     * 汽车模式匹配
     * @return
     */
    public ResultDTO carMatching(Matching matching){

        boolean flag = false;

        //获取每次超级喜欢次数上限
        String likeCount = keyValDAO.selectKey("like");

        //获取每日滑动次数上限
        String slide = keyValDAO.selectKey("slide");


        Model car = modelDAO.selectModel("car", matching.getUserId());

        //获取最后一次滑动更新时间
        //是今天 判断此时是否小于等于上限

        if(isToday(car.getSlideTime())){
            //是今天
            //判断今天次数是否大于上限
            if(car.getSlideCount() > Long.parseLong(slide)){
                return ResultDTOBuilder.failure("1111111","今日滑动次数超过上限");
            }
            //没有超过上限今日滑动次数+1
            modelDAO.updateslidecount("car",matching.getUserId());
        } else {
            modelDAO.updateslidecount1("car",matching.getUserId());
        }

        //like:喜欢；noLike:不喜欢；superLike:超级喜欢；shielding:屏蔽；
        if("like".equals(matching.getOperationStatus()) || "superLike".equals(matching.getOperationStatus())){
            //判断foruser是否喜欢过用户
            int i = mathchingDAO.selectCountCar(matching.getForUser(), matching.getUserId());
            if(i > 0){
                flag = true;
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
                Date superLikeCountTime = car.getSuperLikeCountTime();
                //判断最后一次超级喜欢时间是不是今天
                if(isToday(superLikeCountTime)){
                    //判断是否超过上限
                    if(car.getSuperLikeCount() >= Integer.parseInt(likeCount)){
                        return ResultDTOBuilder.failure("1111111","超级喜欢次数超过今日上限");
                    } else{
                        //没有超过上限 今日超级喜欢次数+1
                        modelDAO.updateSuperLikeCount0("car",matching.getUserId());
                    }
                    //不是今天，超级喜欢次数置为1
                    modelDAO.updateSuperLikeCount1("car",matching.getUserId());
                }
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
        if(flag){
            return ResultDTOBuilder.success("","1000010");
        }
        return ResultDTOBuilder.failure("1111111");
    }

    /**
     * 同性模式
     * @return
     */
    public ResultDTO friendMatching(Matching matching){

        boolean flag = false;

        String likeCount = keyValDAO.selectKey("like");

        //获取每日滑动次数上限
        String slide = keyValDAO.selectKey("slide");


        Model friend = modelDAO.selectModel("friend", matching.getUserId());

        if(isToday(friend.getSlideTime())){
            //是今天
            //判断今天次数是否大于上限
            if(friend.getSlideCount() > Long.parseLong(slide)){
                return ResultDTOBuilder.failure("1111111","今日滑动次数超过上限");
            }
            //没有超过上限今日滑动次数+1
            modelDAO.updateslidecount("friend",matching.getUserId());
        } else {
            modelDAO.updateslidecount1("friend",matching.getUserId());
        }


        //like:喜欢；noLike:不喜欢；superLike:超级喜欢；shielding:屏蔽；
        if("like".equals(matching.getOperationStatus()) || "superLike".equals(matching.getOperationStatus())){
            //判断foruser是否喜欢过用户
            int i = mathchingDAO.selectCountFriend(matching.getForUser(), matching.getUserId());
            if(i > 0){
                flag = true;
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
                Date superLikeCountTime = friend.getSuperLikeCountTime();
                //判断最后一次超级喜欢时间是不是今天
                if(isToday(superLikeCountTime)){
                    //判断是否超过上限
                    if(friend.getSuperLikeCount() >= Integer.parseInt(likeCount)){
                        return ResultDTOBuilder.failure("1111111","超级喜欢次数超过今日上限");
                    } else{
                        //没有超过上限 今日超级喜欢次数+1
                        modelDAO.updateSuperLikeCount0("friend",matching.getUserId());
                    }
                    //不是今天，超级喜欢次数置为1
                    modelDAO.updateSuperLikeCount1("friend",matching.getUserId());
                }
                //被超级喜欢次数加一
                modelDAO.updateSuperLikeCount(matching.getForUser()+"");
            }

            if(flag){
                return ResultDTOBuilder.success("","1000010");
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

        boolean flag = false;

        String likeCount = keyValDAO.selectKey("like");

        //获取每日滑动次数上限
        String slide = keyValDAO.selectKey("slide");

        Model date = modelDAO.selectModel("date", matching.getUserId());

        if(isToday(date.getSlideTime())){
            //是今天
            //判断今天次数是否大于上限
            if(date.getSlideCount() > Long.parseLong(slide)){
                return ResultDTOBuilder.failure("1111111","今日滑动次数超过上限");
            }
            //没有超过上限今日滑动次数+1
            modelDAO.updateslidecount("date",matching.getUserId());
        } else {
            modelDAO.updateslidecount1("date",matching.getUserId());
        }


        //like:喜欢；noLike:不喜欢；superLike:超级喜欢；shielding:屏蔽；
        if("like".equals(matching.getOperationStatus()) || "superLike".equals(matching.getOperationStatus())){
            //判断foruser是否喜欢过用户
            int i = mathchingDAO.selectCountDate(matching.getForUser(), matching.getUserId());
            if(i > 0){
                flag = true;
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
                Date superLikeCountTime = date.getSuperLikeCountTime();
                //判断最后一次超级喜欢时间是不是今天
                if(isToday(superLikeCountTime)){
                    //判断是否超过上限
                    if(date.getSuperLikeCount() >= Integer.parseInt(likeCount)){
                        return ResultDTOBuilder.failure("1111111","超级喜欢次数超过今日上限");
                    } else{
                        //没有超过上限 今日超级喜欢次数+1
                        modelDAO.updateSuperLikeCount0("date",matching.getUserId());
                    }
                    //不是今天，超级喜欢次数置为1
                    modelDAO.updateSuperLikeCount1("date",matching.getUserId());
                }
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

        if(flag){
            return ResultDTOBuilder.success("","1000010");
        }

        return ResultDTOBuilder.failure("1111111");
    }


    public static boolean isToday(Date inputJudgeDate) {
        boolean flag = false;
        //获取当前系统时间
        long longDate = System.currentTimeMillis();
        Date nowDate = new Date(longDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(nowDate);
        String subDate = format.substring(0, 10);
        //定义每天的24h时间范围
        String beginTime = subDate + " 00:00:00";
        String endTime = subDate + " 23:59:59";
        Date paseBeginTime = null;
        Date paseEndTime = null;
        try {
            paseBeginTime = dateFormat.parse(beginTime);
            paseEndTime = dateFormat.parse(endTime);

        } catch (ParseException e) {

        }
        if(inputJudgeDate.after(paseBeginTime) && inputJudgeDate.before(paseEndTime)) {
            flag = true;
        }
        return flag;
    }

}
