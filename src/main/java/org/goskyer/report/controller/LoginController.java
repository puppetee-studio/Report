package org.goskyer.report.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.goskyer.report.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    private static final String OK = "200";

    @RequestMapping(value = "")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String pwd) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);

        String state = shiroLogin(user);

        if (OK.equals(state))
            return "redirect:/index";
        else
            return "redirect:/login";

    }

    @RequestMapping(value = "logout")
    public String logout() {

        Subject subject = SecurityUtils.getSubject();

        if (subject != null)
            subject.logout();

        return "login";
    }

    private String shiroLogin(User user) {

        Subject us = SecurityUtils.getSubject();

        if (us != null && us.isAuthenticated())
            return OK;

        UsernamePasswordToken token = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword().toCharArray(),
                null);

        token.setRememberMe(true);

        // shiro登陆验证
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException ex) {
            return "用户不存在或者密码错误！";
        } catch (IncorrectCredentialsException ex) {
            return "用户不存在或者密码错误！";
        } catch (AuthenticationException ex) {
            return ex.getMessage(); // 自定义报错信息
        } catch (Exception ex) {
            ex.printStackTrace();
            return "内部错误，请重试！";
        }

        return OK;
    }
}
