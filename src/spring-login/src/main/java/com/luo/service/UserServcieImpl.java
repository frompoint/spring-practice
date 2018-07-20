package com.luo.service;

import com.luo.dao.UserDao;
import com.luo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServcieImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId){
        return userDao.selectUserById(userId);
    }
}
