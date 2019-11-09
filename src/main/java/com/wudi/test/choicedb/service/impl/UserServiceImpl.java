package com.wudi.test.choicedb.service.impl;

import com.wudi.test.choicedb.entity.User;
import com.wudi.test.choicedb.mapper.UserMapper;
import com.wudi.test.choicedb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright © 2019 Beijing WINICSSEC Technologies Co.,Ltd. All rights reserved.
 *
 * @Package: com.wudi.test.choicedb.service.impl
 * @Description:
 * @author: liuwudi
 * @date: 2019/11/9 13:59
 * @version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        System.out.println("getUserById***********");
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int addUser(User user) {
//        System.out.println("addUser");
//        return 0;
        int insert = userMapper.insert(user);
        return insert;
    }


}
