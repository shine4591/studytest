package com.andy.user.service;

import com.andy.user.model.DailyNode;

public interface DailyNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyNode record);

    int insertSelective(DailyNode record);

    DailyNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyNode record);

    int updateByPrimaryKey(DailyNode record);
}