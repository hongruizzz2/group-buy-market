package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.CrowdTagsDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 人群标签明细
 * @date 2025-03-15 14:21
 */
@Mapper
public interface ICrowdTagsDetailDao {

    void addCrowdTagsUserId(CrowdTagsDetail crowdTagsDetailReq);

}
