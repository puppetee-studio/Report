package org.goskyer.report.mapper;

import org.goskyer.report.bean.BambooBean;

import java.util.List;

public interface BambooMapper {

    BambooBean getBambooById(int id);

    List<BambooBean> pageBambooList();

    int addBamboo(BambooBean bambooBean);

    int updateBamboo(BambooBean bambooBean);

    int removeBamboo(BambooBean bambooBean);
}
