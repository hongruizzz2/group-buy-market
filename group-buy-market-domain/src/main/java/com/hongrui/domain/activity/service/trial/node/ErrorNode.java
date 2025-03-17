package com.hongrui.domain.activity.service.trial.node;

import com.alibaba.fastjson.JSON;
import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;
import com.hongrui.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.hongrui.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.hongrui.types.design.framework.tree.StrategyHandler;
import com.hongrui.types.enums.ResponseCode;
import com.hongrui.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author hongrui
 * @description 异常节点处理：无营销、流程降级、超时调用等，都可以路由到 ErrorNode 节点统一处理
 * @date 2025-03-17 9:49
 */
@Slf4j
@Service
public class ErrorNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-NoMarketNode userId:{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));

        if (dynamicContext.getGroupBuyActivityDiscountVO() == null || dynamicContext.getSkuVO() == null) {
            log.info("商品无拼团营销配置: {}", requestParameter.getGoodsId());
            throw new AppException(ResponseCode.E0002.getCode(), ResponseCode.E0002.getInfo());
        }

        return TrialBalanceEntity.builder().build();
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }
}
