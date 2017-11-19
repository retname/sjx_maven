package com.service.impl;

import com.dao.DeptDao;
import com.entity.Dept;
import com.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangyu on 2017/11/1.
 */
@Service
public class IDeptServiceImpl implements IDeptService {


    @Resource
    private DeptDao deptDao;


    public void save(Dept dept) {
        this.deptDao.save(dept);
    }
}
