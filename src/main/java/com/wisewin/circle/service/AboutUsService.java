package com.wisewin.circle.service;

import com.wisewin.circle.dao.AboutUsDAO;
import com.wisewin.circle.entity.bo.AboutUsBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("aboutUsService")
@Transactional
public class AboutUsService {
    @Resource
    private AboutUsDAO aboutUsDAO;

    //查询"关于我们"的信息
    public AboutUsBO selectContent() {
        return aboutUsDAO.selectAbout();
    }


}
