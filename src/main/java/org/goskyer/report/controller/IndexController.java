package org.goskyer.report.controller;

import org.goskyer.report.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

}
