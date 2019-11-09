package com.wudi.test.choicedb.bean;

import com.wudi.test.choicedb.enums.DBTypeEnum;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright © 2019 Beijing WINICSSEC Technologies Co.,Ltd. All rights reserved.
 *
 * @Package: com.wudi.test.choicedb.bean
 * @Description:
 * @author: liuwudi
 * @date: 2019/11/9 13:57
 * @version: V1.0
 */
public class DBContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        //  轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            System.out.println("切换到slave1");
        }else {
            set(DBTypeEnum.SLAVE2);
            System.out.println("切换到slave2");
        }
    }

}
