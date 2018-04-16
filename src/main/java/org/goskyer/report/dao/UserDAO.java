package org.goskyer.report.dao;

import org.goskyer.report.bean.User;
import org.goskyer.report.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private UserMapper userMapper;

    public User findUserByName(String username) {
        return userMapper.getUserByName(username);
    }

}