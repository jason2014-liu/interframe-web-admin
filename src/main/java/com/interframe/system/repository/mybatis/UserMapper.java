package com.interframe.system.repository.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
    
    /**
    * TODO
    * @Title: selectUsersByPage
    * @param map
    * @return
     */
    List<User> selectUsersByPage(@Param("map")Map<String, Object> params);
}