package com.wisewin.circle.service;

import com.wisewin.circle.dao.NewbitHelpDAO;
import com.wisewin.circle.entity.bo.NewbitHelpBO;
import com.wisewin.circle.entity.bo.NewbitHelpContentBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("newbitHelpService")
@Transactional
public class NewbitHelpService {
    @Resource
    private NewbitHelpDAO newbitHelpDAO;

    /**
     * 查询新手帮助信息
     *
     * @return
     */
    public List<NewbitHelpBO> selectNewbitHelp() {
        return newbitHelpDAO.selectNewbitHelp();
    }

    /**
     * 查询新手帮助内容
     * @param id
     * @return
     */
    public NewbitHelpContentBO getNewbitHelpContent(Integer id){
        return newbitHelpDAO.getNewbitHelpContent(id);
    }
}
