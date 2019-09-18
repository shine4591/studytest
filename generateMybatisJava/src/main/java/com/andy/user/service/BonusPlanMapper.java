package com.andy.user.service;

import com.andy.user.model.BonusPlan;

public interface BonusPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BonusPlan record);

    int insertSelective(BonusPlan record);

    BonusPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BonusPlan record);

    int updateByPrimaryKey(BonusPlan record);
}