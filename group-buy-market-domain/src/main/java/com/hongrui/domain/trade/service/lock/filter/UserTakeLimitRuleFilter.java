package com.hongrui.domain.trade.service.lock.filter;

import com.hongrui.domain.trade.adapter.repository.ITradeRepository;
import com.hongrui.domain.trade.model.entity.GroupBuyActivityEntity;
import com.hongrui.domain.trade.model.entity.TradeRuleCommandEntity;
import com.hongrui.domain.trade.model.entity.TradeRuleFilterBackEntity;
import com.hongrui.domain.trade.service.lock.factory.TradeLockRuleFilterFactory;
import com.hongrui.types.design.framework.link.model2.handler.ILogicHandler;
import com.hongrui.types.enums.ResponseCode;
import com.hongrui.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hongrui
 * @description 用户参与限制，规则过滤
 * @date 2025-03-18 14:51
 */
@Slf4j
@Service
public class UserTakeLimitRuleFilter implements ILogicHandler<TradeRuleCommandEntity, TradeLockRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradeRuleFilterBackEntity apply(TradeRuleCommandEntity requestParameter, TradeLockRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        log.info("交易规则过滤-用户参与次数校验{} activityId:{}", requestParameter.getUserId(), requestParameter.getActivityId());

        GroupBuyActivityEntity groupBuyActivity = dynamicContext.getGroupBuyActivity();

        // 查询用户在一个拼团活动上参与的次数
        Integer count = repository.queryOrderCountByActivityId(requestParameter.getActivityId(), requestParameter.getUserId());

        if (null != groupBuyActivity.getTakeLimitCount() && count >= groupBuyActivity.getTakeLimitCount()) {
            log.info("用户参与次数校验，已达可参与上限 activityId:{}", requestParameter.getActivityId());
            throw new AppException(ResponseCode.E0103);
        }

        return TradeRuleFilterBackEntity.builder()
                .userTakeOrderCount(count)
                .build();
    }

}