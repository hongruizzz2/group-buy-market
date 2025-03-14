package com.hongrui.domain.activity.service.trial;

import com.hongrui.domain.activity.adapter.repository.IActivityRepository;
import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;
import com.hongrui.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.hongrui.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import com.hongrui.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author hongrui
 * @description 抽象拼团营销支撑类
 * @date 2025-03-14 10:37
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity>
    extends AbstractMultiThreadStrategyRouter<com.hongrui.domain.activity.model.entity.MarketProductEntity,
                    DefaultActivityStrategyFactory.DynamicContext, com.hongrui.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeout = 500;
    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(com.hongrui.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
        // 缺省的方法
    }

}
