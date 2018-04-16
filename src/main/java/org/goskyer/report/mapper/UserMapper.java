package org.goskyer.report.mapper;

import org.goskyer.report.bean.User;

public interface UserMapper {
    User getUserByName(String username);
}
