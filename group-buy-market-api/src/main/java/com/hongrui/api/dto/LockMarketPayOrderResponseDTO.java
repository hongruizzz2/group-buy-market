package com.hongrui.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author hongrui
 * @description 营销支付锁单应答对象
 * @date 2025-03-18 10:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LockMarketPayOrderResponseDTO {
    /** 预购订单ID */
    private String orderId;
    /** 折扣金额 */
    private BigDecimal deductionPrice;
    /** 交易订单状态 */
    private Integer tradeOrderStatus;
}
