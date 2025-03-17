package com.hongrui.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hongrui
 * @description 渠道商品活动配置值对象
 * @date 2025-03-17 9:41
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SCSkuActivityVO {

    /** 渠道 */
    private String source;

    /** 来源 */
    private String channel;

    /** 活动ID */
    private Long activityId;

    /** 商品ID */
    private String goodsId;

}
