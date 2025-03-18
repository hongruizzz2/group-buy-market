package com.hongrui.types.design.framework.link.model2.chain;

import com.hongrui.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @author hongrui
 * @description 业务链路
 * @date 2025-03-18 11:18
 */
public class BusinessLinkedList<T, D, R> extends LinkedList<ILogicHandler<T, D, R>> implements ILogicHandler<T, D, R>{

    public BusinessLinkedList(String name) {
        super(name);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        Node<ILogicHandler<T, D, R>> current = this.first;
        do {
            ILogicHandler<T, D, R> item = current.item;
            R apply = item.apply(requestParameter, dynamicContext);
            if (null != apply) return apply;

            current = current.next;
        } while (null != current);

        return null;
    }

}