package com.hongrui.domain.activity.service.trial.node;

import com.alibaba.fastjson.JSON;
import com.hongrui.domain.activity.model.entity.MarketProductEntity;
import com.hongrui.domain.activity.model.entity.TrialBalanceEntity;
import com.hongrui.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.hongrui.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.hongrui.types.design.framework.tree.StrategyHandler;
import com.hongrui.types.enums.ResponseCode;
import com.hongrui.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hongrui
 * @description 根节点
 * @date 2025-03-14 10:37
 */
@Slf4j
@Service
public class RootNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private SwitchNode switchNode;

    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-RootNode userId:{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));
        // 参数判断
        if (StringUtils.isBlank(requestParameter.getUserId()) || StringUtils.isBlank(requestParameter.getGoodsId()) ||
                StringUtils.isBlank(requestParameter.getSource()) || StringUtils.isBlank(requestParameter.getChannel())) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }
        return router(requestParameter, dynamicContext);

    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get
            (MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return switchNode;
    }

}
