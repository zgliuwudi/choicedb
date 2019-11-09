package com.wudi.test.choicedb.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * Copyright © 2019 Beijing WINICSSEC Technologies Co.,Ltd. All rights reserved.
 *
 * @Package: com.wudi.test.choicedb.bean
 * @Description:
 * @author: liuwudi
 * @date: 2019/11/9 13:57
 * @version: V1.0
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }

}
