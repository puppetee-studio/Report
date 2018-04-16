package org.goskyer.report.service;

import org.goskyer.report.bean.User;
import org.goskyer.report.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User doUserLogin(User info) {

        User user = userDAO.findUserByName(info.getUsername());

        if (info.getUsername().equals(user.getUsername())
                && info.getPassword().equals(user.getPassword())) {
            return user;
        }

        return null;
    }
}
