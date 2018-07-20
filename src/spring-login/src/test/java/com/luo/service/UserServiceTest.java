package com.luo.service;

import com.luo.baseTest.SpringTestCase;
import com.luo.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends SpringTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void selectUserByIdTest(){
        User user = userService.selectUserById(1);
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }
}
