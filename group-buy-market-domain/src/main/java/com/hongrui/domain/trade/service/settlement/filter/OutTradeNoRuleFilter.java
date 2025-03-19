package com.hongrui.domain.trade.service.settlement.filter;

import com.hongrui.domain.trade.adapter.repository.ITradeRepository;
import com.hongrui.domain.trade.model.entity.MarketPayOrderEntity;
import com.hongrui.domain.trade.model.entity.TradeSettlementRuleCommandEntity;
import com.hongrui.domain.trade.model.entity.TradeSettlementRuleFilterBackEntity;
import com.hongrui.domain.trade.service.settlement.factory.TradeSettlementRuleFilterFactory;
import com.hongrui.types.design.framework.link.model2.handler.ILogicHandler;
import com.hongrui.types.enums.ResponseCode;
import com.hongrui.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hongrui
 * @description 外部交易单号过滤，外部交易单号是否为退单
 * @date 2025-03-19 13:58
 */
@Slf4j
@Service
public class OutTradeNoRuleFilter implements ILogicHandler<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradeSettlementRuleFilterBackEntity apply(TradeSettlementRuleCommandEntity requestParameter, TradeSettlementRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        log.info("结算规则过滤-外部单号校验{} outTradeNo:{}", requestParameter.getUserId(), requestParameter.getOutTradeNo());

        // 查询拼团信息
        MarketPayOrderEntity marketPayOrderEntity = repository.queryMarketPayOrderEntityByOutTradeNo(requestParameter.getUserId(), requestParameter.getOutTradeNo());

        if (marketPayOrderEntity == null) {
            log.error("不存在的外部交易单号或用户已退单，不需要做支付订单结算:{} outTradeNo:{}", requestParameter.getUserId(), requestParameter.getOutTradeNo());
            throw new AppException(ResponseCode.E0104);
        }

        dynamicContext.setMarketPayOrderEntity(marketPayOrderEntity);

        return next(requestParameter, dynamicContext);
    }

}