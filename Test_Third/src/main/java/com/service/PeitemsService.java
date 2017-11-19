package com.service;

import com.pojo.Peitems;

/**
 * Created by zhangyu on 2017/10/19.
 */
public interface PeitemsService {


    public Peitems getPeitemsById(Integer itemid);

    public void saveOrUpdate(Peitems peitems);

}
