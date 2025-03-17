package com.hongrui.domain.tag.service;

/**
 * @author hongrui
 * @description 人群标签服务接口
 * @date 2025-03-15 11:20
 */
public interface ITagService {

    /**
     * 执行人群标签批次任务
     * @param tagId 人群ID
     * @param batchId 批次ID
     */
    void execTagBatchJob(String tagId, String batchId);

}
