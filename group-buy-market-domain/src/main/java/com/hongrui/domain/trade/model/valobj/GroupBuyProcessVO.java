package com.hongrui.domain.trade.model.valobj;

import lombok.*;

/**
 * @author hongrui
 * @description 拼团进度值对象
 * @date 2025-03-18 9:40
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyProcessVO {

    /** 目标数量 */
    private Integer targetCount;

    /** 完成数量 */
    private Integer completeCount;

    /** 锁单数量 */
    private Integer lockCount;

}