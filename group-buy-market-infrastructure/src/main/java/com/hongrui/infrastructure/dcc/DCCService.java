package com.hongrui.infrastructure.dcc;

import com.hongrui.types.annotations.DCCValue;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author hongrui
 * @description 动态配置服务
 * @date 2025-03-17 17:06
 */
@Service
public class DCCService {

    /**
     * 降级开关 0:关闭 1:开启
     */
    @DCCValue("downgradeSwitch:0")
    private String downgradeSwitch;

    @DCCValue("cutRange:100")
    private String cutRange;

    /**
     * 白名单用户列表，多个用户ID用逗号分隔
     */
    @DCCValue("whitelistUsers:")
    private String whitelistUsers;

    /**
     * 是否降级
     */
    public boolean isDownGradeSwitch() {
        return downgradeSwitch.equals("1");
    }

    /**
     * 是否在切量范围内
     */
    public boolean isCutRange(String userId) {
        // 计算哈希码的绝对值
        int hashCode = Math.abs(userId.hashCode());

        // 计算哈希码绝对值的后两位
        int lastTwo = hashCode % 100;

        // 判断是否在切量范围内
        if (lastTwo <= Integer.parseInt(cutRange)) {
            return true;
        }
        return false;
    }

    /**
     * 判断用户是否在白名单中
     */
    public boolean isUserInWhitelist(String userId) {
        if (whitelistUsers == null || whitelistUsers.isEmpty()) {
            return false;
        }

        String[] users = whitelistUsers.split(",");
        for (String user : users) {
            if (user.trim().equals(userId)) {
                return true;
            }
        }
        return false;
    }

}