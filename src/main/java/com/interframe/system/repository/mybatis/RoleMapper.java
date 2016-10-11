package com.interframe.system.repository.mybatis;

import org.springframework.stereotype.Repository;

import com.interframe.system.repository.mybatis.model.Role;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}