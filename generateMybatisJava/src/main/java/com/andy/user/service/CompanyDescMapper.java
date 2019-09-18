package com.andy.user.service;

import com.andy.user.model.CompanyDesc;

public interface CompanyDescMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyDesc record);

    int insertSelective(CompanyDesc record);

    CompanyDesc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyDesc record);

    int updateByPrimaryKey(CompanyDesc record);
}