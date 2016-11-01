package com.interframe.system.repository.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.interframe.system.repository.mybatis.model.Permission;

@Repository
public interface PermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    /**
    * TODO 查询模块列表
    * @Title: findModulesByUserId
    * @param userId
    * @return
     */
    List<Permission> findModulesByUserId(String userId);
    
  /**
  * TODO
  * @Title: findMenusByUserId
  * @param params
  * @return
   */
    List<Permission> findMenusByUserId(@Param("map")Map<String, Object> params);
}