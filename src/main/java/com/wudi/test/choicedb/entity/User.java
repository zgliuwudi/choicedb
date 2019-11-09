package com.wudi.test.choicedb.entity;

/**
 * Copyright © 2019 Beijing WINICSSEC Technologies Co.,Ltd. All rights reserved.
 *
 * @Package: com.wudi.test.choicedb.entity
 * @Description:
 * @author: liuwudi
 * @date: 2019/11/9 14:10
 * @version: V1.0
 */
public class User {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
