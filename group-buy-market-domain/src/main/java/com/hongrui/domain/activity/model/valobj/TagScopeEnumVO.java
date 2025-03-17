package com.hongrui.domain.activity.model.valobj;

import lombok.*;

/**
 * @author hongrui
 * @description 活动人群标签作用域范围枚举
 * @date 2025-03-17 11:11
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TagScopeEnumVO {

    VISIBLE(true,false,"是否可见拼团"),
    ENABLE(true,false,"是否可以参与拼团")
    ;

    private Boolean allow;

    private Boolean refuse;

    private String desc;

}