package com.hongrui.api;

import com.hongrui.api.response.Response;

/**
 * @author hongrui
 * @description DCC 动态配置中心
 * @date 2025-03-18 9:08
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}
