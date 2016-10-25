package com.interframe.system.repository.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.interframe.system.repository.mybatis.model.Org;

@Repository
public interface OrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
    
    /**
    * TODO 查询组织列表
    * @Title: selectAllOrg
    * @return
     */
    List<Org> selectAllOrg();
}