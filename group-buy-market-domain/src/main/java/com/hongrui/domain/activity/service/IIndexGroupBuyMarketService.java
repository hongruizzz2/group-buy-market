package com.hongrui.domain.activity.service;

import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @author hongrui
 * @description 首页营销服务接口
 * @date 2025-03-14 10:38
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
