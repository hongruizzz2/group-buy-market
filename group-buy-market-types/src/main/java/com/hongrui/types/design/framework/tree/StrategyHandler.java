package com.hongrui.types.design.framework.tree;

import org.springframework.expression.spel.ast.NullLiteral;

/**
 * @author hongrui
 * @description 受理处理器
 * T 入参类型
 * D 上下文参数
 * R 返回参数
 * @date 2025-03-14 10:10
 */
public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T ,D) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;
}
