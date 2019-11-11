package com.wisewin.circle.entity.bo.common.base;

import com.wisewin.circle.entity.bo.AdminBO;
import com.wisewin.circle.entity.bo.UserBO;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class BaseModel implements Serializable {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/** 获取登录用户*/
   public UserBO getLoginUser (HttpServletRequest request ) {
        UserBO userBO = new UserBO();
        return  userBO;
    }
}
