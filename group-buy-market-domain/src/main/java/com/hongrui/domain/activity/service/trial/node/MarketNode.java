package com.hongrui.domain.activity.service.trial.node;

import com.alibaba.fastjson.JSON;
import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;
import com.hongrui.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.hongrui.domain.activity.model.valobj.SkuVO;
import com.hongrui.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.hongrui.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.hongrui.domain.activity.service.trial.thread.QueryGroupBuyActivityDiscountVOThreadTask;
import com.hongrui.domain.activity.service.trial.thread.QuerySkuVOFromDBThreadTask;
import com.hongrui.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.nio.ch.ThreadPool;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author hongrui
 * @description 营销优惠节点
 * @date 2025-03-14 10:37
 */
@Slf4j
@Service
public class MarketNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private EndNode endNode;

    @Override
    protected void multiThread(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext
            dynamicContext) throws InterruptedException, TimeoutException, ExecutionException {
        // 异步查询活动配置
        QueryGroupBuyActivityDiscountVOThreadTask queryGroupBuyActivityDiscountVOThreadTask =
                new QueryGroupBuyActivityDiscountVOThreadTask(
                    requestParameter.getSource(),
                    requestParameter.getChannel(),
                    repository
                );
        FutureTask<GroupBuyActivityDiscountVO> groupBuyActivityDiscountVOFutureTask =
                new FutureTask<>(queryGroupBuyActivityDiscountVOThreadTask);
        threadPoolExecutor.execute(groupBuyActivityDiscountVOFutureTask);

        // 异步查询商品信息 - 在实际生产中，有同步库或商品查询接口 这里暂时使用DB方式查询
        QuerySkuVOFromDBThreadTask querySkuVOFromDBThreadTask = new QuerySkuVOFromDBThreadTask(
                requestParameter.getGoodsId(),
                repository
        );
        FutureTask<SkuVO> skuVOFutureTask = new FutureTask<>(querySkuVOFromDBThreadTask);
        threadPoolExecutor.execute(skuVOFutureTask);

        // 写入上下文
        dynamicContext.setGroupBuyActivityDiscountVO(groupBuyActivityDiscountVOFutureTask.get(
                timeout,
                TimeUnit.MINUTES)
        );
        dynamicContext.setSkuVO(skuVOFutureTask.get(
                timeout,
                TimeUnit.MINUTES)
        );

        log.info("拼团商品查询试算服务-MarketNode userId:{} 异步线程加载数据「GroupBuyActivityDiscountVO、SkuVO」完成",
                requestParameter.getUserId());
    }

    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter,
                                         DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-MarketNode userId:{} requestParameter:{}", requestParameter.getUserId(),
                JSON.toJSONString(requestParameter));

        // todo xfg 拼团优惠试算

        return router(requestParameter, dynamicContext);

    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext,
            TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return endNode;
    }
}
