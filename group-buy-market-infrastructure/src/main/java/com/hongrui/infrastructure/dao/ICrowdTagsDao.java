package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.CrowdTags;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 人群标签
 * @date 2025-03-15 14:21
 */
@Mapper
public interface ICrowdTagsDao {

    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);

}
