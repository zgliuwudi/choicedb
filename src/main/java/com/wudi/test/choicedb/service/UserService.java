package com.wudi.test.choicedb.service;

import com.wudi.test.choicedb.entity.User;

public interface UserService {
    User getUserById(Integer id);

    int addUser(User user);
}