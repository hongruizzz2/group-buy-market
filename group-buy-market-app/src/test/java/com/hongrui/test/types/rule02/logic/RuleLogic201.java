package com.hongrui.test.types.rule02.logic;

import com.hongrui.test.types.rule02.factory.Rule02TradeRuleFactory;
import com.hongrui.types.design.framework.link.model2.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author hongrui
 * @description
 * @date 2025-03-18 11:27
 */
@Slf4j
@Service
public class RuleLogic201 implements ILogicHandler<String, Rule02TradeRuleFactory.DynamicContext, XxxResponse> {

    public XxxResponse apply(String requestParameter, Rule02TradeRuleFactory.DynamicContext dynamicContext) throws Exception{

        log.info("link model02 RuleLogic201");

        return next(requestParameter, dynamicContext);
    }

}