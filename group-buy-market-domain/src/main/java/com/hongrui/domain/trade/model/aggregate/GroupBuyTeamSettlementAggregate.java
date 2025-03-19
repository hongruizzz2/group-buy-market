package com.hongrui.domain.trade.model.aggregate;

import com.hongrui.domain.trade.model.entity.GroupBuyTeamEntity;
import com.hongrui.domain.trade.model.entity.TradePaySuccessEntity;
import com.hongrui.domain.trade.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hongrui
 * @description 拼团结算聚合
 * @date 2025-03-18 16:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyTeamSettlementAggregate {

    /** 用户实体对象 */
    private UserEntity userEntity;
    /** 拼团组队实体对象 */
    private GroupBuyTeamEntity groupBuyTeamEntity;
    /** 交易支付订单实体对象 */
    private TradePaySuccessEntity tradePaySuccessEntity;

}