package com.hongrui.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hongrui
 * @description 策略路由抽象类
 * T 入参类型
 * D 上下文参数
 * R 返参类型
 * @date 2025-03-14 10:11
 */
public abstract class AbstractStrategyRouter<T, D, R> implements StrategyHandler<T, D, R>, StrategyMapper<T, D, R>{

    @Getter
    @Setter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if (strategyHandler != null) {
            return strategyHandler.apply(requestParameter, dynamicContext);
        }
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

}
