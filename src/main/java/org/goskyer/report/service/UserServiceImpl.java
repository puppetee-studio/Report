package org.goskyer.report.service;

import org.goskyer.report.bean.User;
import org.goskyer.report.service.impl.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final String username = "admin";
    private static final String password = "123456";

    public User doUserLogin(User info) {

        if (username.equals(info.getUsername()) && password.equals(info.getPassword()))
            return info;

        return null;
    }
}
