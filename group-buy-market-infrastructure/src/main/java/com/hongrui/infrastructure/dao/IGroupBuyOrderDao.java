package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.GroupBuyOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 用户拼单
 * @date 2025-03-18 10:06
 */
@Mapper
public interface IGroupBuyOrderDao {

    void insert(GroupBuyOrder groupBuyOrder);

    int updateAddLockCount(String teamId);

    int updateSubtractionLockCount(String teamId);

    GroupBuyOrder queryGroupBuyProgress(String teamId);

}