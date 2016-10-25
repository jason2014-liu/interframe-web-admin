package com.interframe.system.repository.mybatis.model;

import java.math.BigDecimal;

public class Org {
    private String id;

    private String name;

    private String parentId;

    private String valid;

    private BigDecimal sortNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public BigDecimal getSortNum() {
        return sortNum;
    }

    public void setSortNum(BigDecimal sortNum) {
        this.sortNum = sortNum;
    }
}