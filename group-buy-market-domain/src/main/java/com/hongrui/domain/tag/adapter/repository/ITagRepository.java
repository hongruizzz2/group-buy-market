package com.hongrui.domain.tag.adapter.repository;

import com.hongrui.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @author hongrui
 * @description 人群标签仓储接口
 * @date 2025-03-15 11:24
 */
public interface ITagRepository {

    /**
     * 查询人群标签对象
     * @param tagId
     * @param batchId
     * @return
     */
    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    /**
     * 添加用户人群标签
     * @param tagId
     * @param userId
     */
    void addCrowdTagsUserId(String tagId, String userId);

    /**
     * 更新人群标签统计
     * @param tagId
     * @param count
     */
    void updateCrowdTagsStatistics(String tagId, int count);

}
