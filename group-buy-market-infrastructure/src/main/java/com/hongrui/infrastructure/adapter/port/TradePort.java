package com.hongrui.infrastructure.adapter.port;

import com.hongrui.domain.trade.adapter.port.ITradePort;
import com.hongrui.domain.trade.model.entity.NotifyTaskEntity;
import com.hongrui.infrastructure.gateway.GroupBuyNotifyService;
import com.hongrui.infrastructure.redis.IRedisService;
import com.hongrui.types.enums.NotifyTaskHTTPEnumVO;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hongrui
 * @description
 * @date 2025-03-20 9:06
 */
@Service
public class TradePort implements ITradePort {

    @Resource
    private GroupBuyNotifyService groupBuyNotifyService;
    @Resource
    private IRedisService redisService;

    @Override
    public String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception {
        RLock lock = redisService.getLock(notifyTask.lockKey());
        try {
            // group-buy-market 拼团服务端会被部署到多台应用服务器上，那么就会有很多任务一起执行。这个时候要进行抢占，避免被多次执行
            if (lock.tryLock(3, 0, TimeUnit.SECONDS)) {
                try {
                    // 无效的 notifyUrl 则直接返回成功
                    if (StringUtils.isBlank(notifyTask.getNotifyUrl()) || "暂无".equals(notifyTask.getNotifyUrl())) {
                        return NotifyTaskHTTPEnumVO.SUCCESS.getCode();
                    }
                    return groupBuyNotifyService.groupBuyNotify(notifyTask.getNotifyUrl(), notifyTask.getParameterJson());
                } finally {
                    if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                }
            }
            return NotifyTaskHTTPEnumVO.NULL.getCode();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            return NotifyTaskHTTPEnumVO.NULL.getCode();
        }
    }
}