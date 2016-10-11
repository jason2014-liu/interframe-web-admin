package com.interframe.system.repository.mybatis;

import org.springframework.stereotype.Repository;

import com.interframe.system.repository.mybatis.model.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}