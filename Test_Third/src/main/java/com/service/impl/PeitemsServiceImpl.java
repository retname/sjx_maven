package com.service.impl;

import com.dao.PeitemsDao;
import com.pojo.Peitems;
import com.service.PeitemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangyu on 2017/10/19.
 */
@Service("peitemsServiceImpl")
public class PeitemsServiceImpl implements PeitemsService {

    @Resource
    private PeitemsDao  peitemsDao;

    public Peitems getPeitemsById(Integer itemid) {
        return this.peitemsDao.getPeitemsById(itemid);
    }

    public void saveOrUpdate(Peitems peitems) {
        this.peitemsDao.saveOrUpdate(peitems);
    }

}
