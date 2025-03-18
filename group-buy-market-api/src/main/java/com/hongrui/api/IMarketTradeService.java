package com.hongrui.api;

import com.hongrui.api.dto.LockMarketPayOrderRequestDTO;
import com.hongrui.api.dto.LockMarketPayOrderResponseDTO;
import com.hongrui.api.response.Response;

/**
 * @author hongrui
 * @description 营销交易服务接口
 * @date 2025-03-18 10:03
 */
public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);

}
