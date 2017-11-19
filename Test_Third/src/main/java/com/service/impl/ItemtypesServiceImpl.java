package com.service.impl;

import com.dao.ItemtypesDao;
import com.pojo.Peitems;
import com.service.ItemtypesService;
import org.springframework.stereotype.Service;
import com.pojo.Itemtypes;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/18.
 */
@Service("itemServiceImpl")
public class ItemtypesServiceImpl implements ItemtypesService {


    @Resource
    private ItemtypesDao itemtypesDao;

    public List<Itemtypes> getAll() {
        return this.itemtypesDao.getAll();
    }



    public Itemtypes getItemtypesById(Integer id) {
        return this.itemtypesDao.getItemtypesById(id);
    }
}
