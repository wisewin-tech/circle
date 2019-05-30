package com.wisewin.circle.service;

import com.wisewin.circle.dao.TestDAO;
import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.UserBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/2/28.
 */
@Service("TestService")
@Transactional
public class TestService {
    @Resource
    private TestDAO testDAO;




   public AdminBO test() {
        return testDAO.test();
    }
}
