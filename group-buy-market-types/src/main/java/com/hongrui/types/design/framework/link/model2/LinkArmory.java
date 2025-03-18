package com.hongrui.types.design.framework.link.model2;

import com.hongrui.types.design.framework.link.model2.chain.BusinessLinkedList;
import com.hongrui.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @author hongrui
 * @description 链路装配
 * @date 2025-03-18 11:17
 */
public class LinkArmory<T, D, R> {

    private final BusinessLinkedList<T, D, R> logicLink;

    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);
        }
    }

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}