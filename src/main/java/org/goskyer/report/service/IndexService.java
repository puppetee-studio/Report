package org.goskyer.report.service;

import org.goskyer.report.dao.IndexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    private IndexDAO indexDAO;

}
