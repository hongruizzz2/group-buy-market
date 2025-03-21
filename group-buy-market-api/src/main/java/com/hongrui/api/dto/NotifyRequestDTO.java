package com.hongrui.api.dto;

import lombok.Data;

import java.util.List;

/**
 * @author hongrui
 * @description 回调请求对象
 * @date 2025-03-21 15:37
 */
@Data
public class NotifyRequestDTO {

    /** 组队ID */
    private String teamId;

    /** 外部单号 */
    private List<String> outTradeNoList;

}