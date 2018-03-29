package org.goskyer.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("login")
public class LoginController {

    @RequestMapping(value = "/")
    public String loginView() {
        return "login";
    }

}
