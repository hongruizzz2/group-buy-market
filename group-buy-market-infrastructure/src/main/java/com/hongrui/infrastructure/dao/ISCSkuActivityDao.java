package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.SCSkuActivity;
import com.sun.org.glassfish.gmbal.ManagedObject;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 渠道商品活动配置关联Dao
 * @date 2025-03-17 10:09
 */
@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);

}