package com.hongrui.types.design.framework.tree;

/**
 * @author hongrui
 * @description 策略映射器
 * @date 2025-03-14 10:09
 */
public interface StrategyMapper<T, D, R> {

    /**
     * 获取待执行策略
     * @param requestParameter 入参
     * @param dynamicContext 上下文
     * @return StrategyHadnler 受理处理器
     * @throws Exception
     */
    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;
}
