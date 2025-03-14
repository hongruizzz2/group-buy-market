package com.hongrui.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author hongrui
 * @description 异步资源加载策略
 * @date 2025-03-14 14:00
 */
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> implements StrategyHandler<T, D, R>, StrategyMapper<T, D, R>{

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

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        // 异步加载数据
        multiThread(requestParameter, dynamicContext);
        // 业务流程受理
        return doApply(requestParameter, dynamicContext);
    }


    /**
     * 异步加载数据
     * @param requestParameter
     * @param dynamicContext
     */
    protected abstract void multiThread(T requestParameter, D dynamicContext) throws InterruptedException, TimeoutException, ExecutionException;

    /**
     * 业务流程受理
     * @param requestParameter
     * @param dynamicContext
     * @return
     * @throws Exception
     */
    protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;
}
