package com.interframe.hr.repository.mybatis;

import com.interframe.hr.repository.mybatis.model.SysPermission;

public interface SysPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.SYS_PERMISSION
     *
     * @mbg.generated Mon Oct 10 16:33:46 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.SYS_PERMISSION
     *
     * @mbg.generated Mon Oct 10 16:33:46 CST 2016
     */
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.SYS_PERMISSION
     *
     * @mbg.generated Mon Oct 10 16:33:46 CST 2016
     */
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.SYS_PERMISSION
     *
     * @mbg.generated Mon Oct 10 16:33:46 CST 2016
     */
    SysPermission selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.SYS_PERMISSION
     *
     * @mbg.generated Mon Oct 10 16:33:46 CST 2016
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.SYS_PERMISSION
     *
     * @mbg.generated Mon Oct 10 16:33:46 CST 2016
     */
    int updateByPrimaryKey(SysPermission record);
}