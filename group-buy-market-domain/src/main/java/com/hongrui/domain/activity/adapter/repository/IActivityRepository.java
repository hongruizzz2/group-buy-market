package com.hongrui.domain.activity.adapter.repository;

import com.hongrui.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.hongrui.domain.activity.model.valobj.SCSkuActivityVO;
import com.hongrui.domain.activity.model.valobj.SkuVO;

/**
 * @author hongrui
 * @description 活动仓储
 * @date 2025-03-14 14:19
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowdRange(String tagId, String userId);

    boolean downgradeSwitch();

    boolean cutRange(String userId);

    /**
     * 判断用户是否在白名单中
     */
    boolean isUserInWhitelist(String userId);

}