package com.hongrui.trigger.http;

import com.hongrui.api.IDCCService;
import com.hongrui.api.response.Response;
import com.hongrui.types.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hongrui
 * @description 动态配置管理 - 接口
 * @date 2025-03-17 19:19
 */
@Slf4j
@RestController()
@CrossOrigin("*")
@RequestMapping("/api/v1/gbm/dcc/")
public class DCCController implements IDCCService {

    @Resource
    private RTopic dccTopic;

    /**
     * 动态值变更
     * <p>
     * curl http://127.0.0.1:8091/api/v1/gbm/dcc/update_config?key=downgradeSwitch&value=1
     * curl http://127.0.0.1:8091/api/v1/gbm/dcc/update_config?key=cutRange&value=0
     */
    @RequestMapping(value = "update_config", method = RequestMethod.GET)
    @Override
    public Response<Boolean> updateConfig(@RequestParam String key, @RequestParam String value) {
        try {
            log.info("DCC 动态配置值变更 key:{} value:{}", key, value);
            dccTopic.publish(key + "," + value);
            return Response.<Boolean>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .build();
        } catch (Exception e) {
            log.error("DCC 动态配置值变更失败 key:{} value:{}", key, value, e);
            return Response.<Boolean>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

    /**
     * 添加用户到白名单
     */
    @RequestMapping(value = "add_whitelist_user", method = RequestMethod.GET)
    public Response<Boolean> addWhitelistUser(@RequestParam String userId) {
        try {
            log.info("添加用户到白名单 userId:{}", userId);
            // 获取当前白名单
            dccTopic.publish("whitelistUsers," + userId);
            return Response.<Boolean>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .build();
        } catch (Exception e) {
            log.error("添加用户到白名单失败 userId:{}", userId, e);
            return Response.<Boolean>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

}