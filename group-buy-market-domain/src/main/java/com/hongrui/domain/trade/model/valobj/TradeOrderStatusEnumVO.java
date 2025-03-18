package com.hongrui.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hongrui
 * @description 交易订单状态枚举
 * @date 2025-03-18 9:37
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TradeOrderStatusEnumVO {

    CREATE(0, "初始创建"),
    COMPLETE(1, "消费完成"),
    CLOSE(2, "超时关单")
    ;

    private Integer code;

    private String info;

    public static TradeOrderStatusEnumVO valueOf(Integer code) {
        switch (code) {
            case 0:
                return CREATE;
            case 1:
                return COMPLETE;
            case 2:
                return CLOSE;
        }
        return CREATE;
    }

}