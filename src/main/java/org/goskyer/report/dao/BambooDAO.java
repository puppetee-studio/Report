package org.goskyer.report.dao;

import org.goskyer.report.bean.BambooBean;
import org.goskyer.report.mapper.BambooMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BambooDAO {

    @Autowired
    private BambooMapper bambooMapper;

    public List<BambooBean> pageBambooList() {
        return bambooMapper.pageBambooList();
    }

    public BambooBean getBambooById(int id) {
        return bambooMapper.getBambooById(id);
    }

    public int addBamboo(BambooBean bambooBean) {
        return bambooMapper.addBamboo(bambooBean);
    }

    public int updateBamboo(BambooBean bambooBean) {
        return bambooMapper.updateBamboo(bambooBean);
    }

    public int removeBamboo(BambooBean bambooBean) {
        return bambooMapper.removeBamboo(bambooBean);
    }
}
