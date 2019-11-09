package com.wudi.test.choicedb.aop;

import com.wudi.test.choicedb.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2019 Beijing WINICSSEC Technologies Co.,Ltd. All rights reserved.
 *
 * @Package: com.wudi.test.choicedb.aop
 * @Description:
 * @author: liuwudi
 * @date: 2019/11/9 13:58
 * @version: V1.0
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.wudi.test.choicedb.annotation.Master) " +
            "&& (execution(* com.wudi.test.choicedb.service..*.select*(..)) " +
            "|| execution(* com.wudi.test.choicedb.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.wudi.test.choicedb.annotation.Master) " +
            "|| execution(* com.wudi.test.choicedb.service..*.insert*(..)) " +
            "|| execution(* com.wudi.test.choicedb.service..*.add*(..)) " +
            "|| execution(* com.wudi.test.choicedb.service..*.update*(..)) " +
            "|| execution(* com.wudi.test.choicedb.service..*.edit*(..)) " +
            "|| execution(* com.wudi.test.choicedb.service..*.delete*(..)) " +
            "|| execution(* com.wudi.test.choicedb.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


/**
 * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
 */
//    @Before("execution(* com.wudi.test.choicedb.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
