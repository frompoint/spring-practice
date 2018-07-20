package com.luo.service;

import com.luo.domain.User;

public interface UserService {
    /**
     * @param userId
     * @return User
     */
    User selectUserById(Integer userId);
}
