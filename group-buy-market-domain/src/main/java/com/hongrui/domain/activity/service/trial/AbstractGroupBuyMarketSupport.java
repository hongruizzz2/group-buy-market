package com.hongrui.domain.activity.service.trial;

import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;
import com.hongrui.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.hongrui.types.design.framework.tree.AbstractStrategyRouter;

/**
 * @author hongrui
 * @description 抽象拼团营销支撑类
 * @date 2025-03-14 10:37
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity>
    extends AbstractStrategyRouter<com.hongrui.domain.activity.model.entity.MarketProductEntity,
                DefaultActivityStrategyFactory.DynamicContext, com.hongrui.domain.activity.model.entity.TrialBalanceEntity> {

}
