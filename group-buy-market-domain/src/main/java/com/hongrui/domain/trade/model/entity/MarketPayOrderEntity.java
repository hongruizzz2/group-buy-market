package com.hongrui.domain.trade.model.entity;

import com.hongrui.domain.trade.model.valobj.TradeOrderStatusEnumVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author hongrui
 * @description 拼团，预购订单营销实体对象
 * @date 2025-03-18 9:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarketPayOrderEntity {

    /** 预购订单ID */
    private String orderId;
    /** 折扣金额 */
    private BigDecimal deductionPrice;
    /** 交易订单状态枚举 */
    private TradeOrderStatusEnumVO tradeOrderStatusEnumVO;

}
