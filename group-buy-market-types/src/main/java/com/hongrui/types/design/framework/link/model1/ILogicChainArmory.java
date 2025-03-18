package com.hongrui.types.design.framework.link.model1;

/**
 * @author hongrui
 * @description 责任链装配
 * @date 2025-03-18 11:12
 */
public interface ILogicChainArmory<T, D, R> {

    ILogicLink<T, D, R> next();

    ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next);
}
