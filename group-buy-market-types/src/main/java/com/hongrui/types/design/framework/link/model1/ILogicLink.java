package com.hongrui.types.design.framework.link.model1;

/**
 * @author hongrui
 * @description 规则责任链接口
 * @date 2025-03-18 11:12
 */
public interface ILogicLink<T, D, R> extends ILogicChainArmory<T, D, R>{

    R apply(T requestParameter, D dynamicContext) throws Exception;

}