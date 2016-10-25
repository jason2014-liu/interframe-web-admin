package com.interframe.system.repository.mybatis;

import java.util.List;

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
    
    User SelectByLoginName(String loginName);
    
    List<User> selectUsersByPage(String orgId, Page<User> page);
}