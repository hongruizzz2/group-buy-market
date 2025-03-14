package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 商品查询
 * @date 2025-03-14 15:24
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
