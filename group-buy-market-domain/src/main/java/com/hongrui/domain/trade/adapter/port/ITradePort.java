package com.hongrui.domain.trade.adapter.port;

import com.hongrui.domain.trade.model.entity.NotifyTaskEntity;

/**
 * @author hongrui
 * @description 交易接口服务接口
 * @date 2025-03-20 8:47
 */
public interface ITradePort {


    String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception;

}