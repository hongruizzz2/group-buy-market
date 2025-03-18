package com.hongrui.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hongrui
 * @description 用户实体对象
 * @date 2025-03-18 9:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String userId;

}