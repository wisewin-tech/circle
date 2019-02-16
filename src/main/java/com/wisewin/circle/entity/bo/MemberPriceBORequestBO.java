package com.wisewin.circle.entity.bo;

import java.math.BigDecimal;

/**
 * Created by yxw on 2018/11/7.
 */
public class MemberPriceBORequestBO {
    private Integer id;
    private BigDecimal discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
