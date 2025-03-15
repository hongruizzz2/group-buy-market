package com.hongrui.domain.activity.service.discount;

import com.hongrui.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @author hongrui
 * @description 折扣计算服务
 * @date 2025-03-15 9:11
 */
public interface IDiscountCalculateService {

    /**
     * 折扣计算
     * @param userId 用户ID
     * @param originalPrice 商品原始价格
     * @param groupBuyDiscount 折扣计划配置
     * @return 商品优惠价格
     */
    BigDecimal calculate(String userId, BigDecimal originalPrice,
                         GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}