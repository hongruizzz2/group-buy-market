package com.hongrui.domain.activity.adapter.repository;

import com.hongrui.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.hongrui.domain.activity.model.valobj.SkuVO;

/**
 * @author hongrui
 * @description 活动仓储
 * @date 2025-03-14 14:19
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);

}
