package com.hongrui.types.design.framework.link.model2.chain;

/**
 * @author hongrui
 * @description 链接口
 * @date 2025-03-18 11:18
 */
public interface ILink<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

}