package com.hongrui.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hongrui
 * @description 拼团交易命令实体
 * @date 2025-03-19 11:38
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeLockRuleCommandEntity {

    private String userId;

    private Long activityId;

}