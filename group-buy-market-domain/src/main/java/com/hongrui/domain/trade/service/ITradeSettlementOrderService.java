package com.hongrui.domain.trade.service;

import com.hongrui.domain.trade.model.entity.TradePaySettlementEntity;
import com.hongrui.domain.trade.model.entity.TradePaySuccessEntity;

/**
 * @author hongrui
 * @description 拼团交易结算服务接口
 * @date 2025-03-18 16:15
 */
public interface ITradeSettlementOrderService {

    /**
     * 营销结算
     * @param tradePaySuccessEntity 交易支付订单实体对象
     * @return 交易结算订单实体
     */
    TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity) throws Exception;

}