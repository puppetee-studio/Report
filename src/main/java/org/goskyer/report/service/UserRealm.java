package org.goskyer.report.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.goskyer.report.bean.User;
import org.goskyer.report.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    private static final String SESSION_USER_KEY = "gray_report";

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(SESSION_USER_KEY);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addRole(user.getRole().trim());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 把token转换成User对象
        User userLogin = tokenToUser((UsernamePasswordToken) token);

        // 验证用户是否可以登录
        User ui = userService.doUserLogin(userLogin);

        if(ui == null) return null; // 异常处理，找不到数据

        // 设置session
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SESSION_USER_KEY, ui);

        //当前 Realm 的 name
        String realmName = this.getName();

        //登陆的主要信息: 可以是一个实体类的对象, 但该实体类的对象一定是根据 token 的 username 查询得到的.
//      Object principal = ui.getUsername();
        Object principal = token.getPrincipal();

        return new SimpleAuthenticationInfo(principal, userLogin.getPassword(), realmName);
    }

    private User tokenToUser(UsernamePasswordToken authcToken) {

        User user = new User();
        user.setUsername(authcToken.getUsername());
        user.setPassword(String.valueOf(authcToken.getPassword()));

        return user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
