package com.hongrui.types.design.framework.link.model2.handler;

/**
 * @author hongrui
 * @description 逻辑处理器
 * @date 2025-03-18 11:18
 */
public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext) {
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}