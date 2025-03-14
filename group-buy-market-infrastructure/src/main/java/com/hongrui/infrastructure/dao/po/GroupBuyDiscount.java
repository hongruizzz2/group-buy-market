package com.hongrui.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hongrui
 * @description 折扣配置
 * @date 2025-03-14 9:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyDiscount {
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 折扣活动呢ID
     */
    private Integer discountId;
    /**
     * 折扣标题
     *
     */
    private String discountName;
    /**
     * 折扣描述
     */
    private String discountDesc;
    /**
     * 折扣类型（0：base、1：tag）
     */
    private Byte discountType;
    /**
     * 营销优惠计划（ZJ：直减、MJ：满减、N元购）
     */
    private String marketPlan;
    /**
     * 营销优惠表达式
     */
    private String marketExpr;
    /**
     * 人群标签，特定限定优惠
     */
    private String tagId;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
