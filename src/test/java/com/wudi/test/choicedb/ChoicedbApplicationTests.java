package com.wudi.test.choicedb;

import com.wudi.test.choicedb.entity.User;
import com.wudi.test.choicedb.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChoicedbApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void testRead() {
        User userById = userService.getUserById(1);
        System.out.println(userById.getName());
    }

    @Test
    public void testWrite() {
	    User user = new User();
		user.setName("k123");
		int i = userService.addUser(user);
		System.out.println(i);
    }


}