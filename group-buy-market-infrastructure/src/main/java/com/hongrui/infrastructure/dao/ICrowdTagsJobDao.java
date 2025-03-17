package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 人群标签任务
 * @date 2025-03-15 14:21
 */
@Mapper
public interface ICrowdTagsJobDao {

    CrowdTagsJob queryCrowdTagsJob(CrowdTagsJob crowdTagsJobReq);

}