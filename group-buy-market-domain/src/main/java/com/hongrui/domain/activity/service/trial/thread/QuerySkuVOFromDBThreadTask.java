package com.hongrui.domain.activity.service.trial.thread;

import com.hongrui.domain.activity.adapter.repository.IActivityRepository;
import com.hongrui.domain.activity.model.valobj.SkuVO;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @author hongrui
 * @description 查询商品信息任务
 * @date 2025-03-14 14:22
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }

}
