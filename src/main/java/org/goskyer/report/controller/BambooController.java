package org.goskyer.report.controller;

import com.github.pagehelper.PageHelper;
import org.goskyer.report.base.ResultBean;
import org.goskyer.report.bean.BambooBean;
import org.goskyer.report.dao.BambooDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "bamboo")
public class BambooController {

    @Autowired
    private BambooDAO bambooDAO;

    @RequestMapping(value = "page")
    @ResponseBody
    private ResultBean pageBambooList(int page, int size) {

        PageHelper.startPage(page, size);

        List<BambooBean> list = bambooDAO.pageBambooList();

        return new ResultBean(list);
    }

    @RequestMapping(value = "getBambooById")
    @ResponseBody
    private ResultBean getBambooById(int id) {

        BambooBean bambooBean = bambooDAO.getBambooById(id);

        return new ResultBean(bambooBean);
    }

    @RequestMapping(value = "add")
    @ResponseBody
    private ResultBean addBamboo(BambooBean param) {

        int count = bambooDAO.addBamboo(param);

        if (count > 0)
            return new ResultBean();
        else
            return new ResultBean(-1, "failed");
    }

    @RequestMapping(value = "remove")
    @ResponseBody
    private ResultBean removeBamboo(BambooBean param) {

        int count = bambooDAO.removeBamboo(param);

        if (count > 0)
            return new ResultBean();
        else
            return new ResultBean(-1, "failed");

    }

    @RequestMapping(value = "update")
    @ResponseBody
    private ResultBean updateBamboo(BambooBean param) {

        int count = bambooDAO.updateBamboo(param);

        if (count > 0)
            return new ResultBean();
        else
            return new ResultBean(-1, "failed");

    }

}
