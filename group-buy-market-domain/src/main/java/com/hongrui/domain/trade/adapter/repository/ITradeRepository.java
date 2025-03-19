package com.hongrui.domain.trade.adapter.repository;

import com.hongrui.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.hongrui.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import com.hongrui.domain.trade.model.entity.GroupBuyActivityEntity;
import com.hongrui.domain.trade.model.entity.GroupBuyTeamEntity;
import com.hongrui.domain.trade.model.entity.MarketPayOrderEntity;
import com.hongrui.domain.trade.model.valobj.GroupBuyProcessVO;

/**
 * @author hongrui
 * @description 交易仓储服务接口
 * @date 2025-03-18 9:49
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProcessVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    void settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

}