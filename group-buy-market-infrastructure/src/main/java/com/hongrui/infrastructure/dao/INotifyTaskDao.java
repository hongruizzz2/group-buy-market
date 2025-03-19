package com.hongrui.infrastructure.dao;

import com.hongrui.infrastructure.dao.po.NotifyTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hongrui
 * @description 回调任务
 * @date 2025-03-18 16:28
 */
@Mapper
public interface INotifyTaskDao {

    void insert(NotifyTask notifyTask);

}