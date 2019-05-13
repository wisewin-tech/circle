package com.wisewin.circle.service;

import com.wisewin.circle.entity.bo.UserBO;
import com.wisewin.circle.util.jwtUtil.JwtUtil;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {

    /**
     * 获取用户信息
     * @param Token
     * @return
     */
    public UserBO  getUserByToken(String Token){
        Integer userId = JwtUtil.verify(Token);
        if(userId==null){
            return  null;
        }

        return null;
    }




}
