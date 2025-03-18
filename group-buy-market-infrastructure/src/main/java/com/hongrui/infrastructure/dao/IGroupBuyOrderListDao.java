package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.GroupBuyOrderList;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 用户拼单明细
 * @date 2025-03-18 10:06
 */
@Mapper
public interface IGroupBuyOrderListDao {

    void insert(GroupBuyOrderList groupBuyOrderListReq);

    GroupBuyOrderList queryGroupBuyOrderRecordByOutTradeNo(GroupBuyOrderList groupBuyOrderListReq);

}