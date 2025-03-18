package com.hongrui.domain.activity.service;

import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;
import com.hongrui.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.hongrui.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hongrui
 * @description 首页营销服务 实现
 * @date 2025-03-14 10:38
 */
@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {
        // 获取执行策略
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();
        // 受理试算操作
        return strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());
    }

}