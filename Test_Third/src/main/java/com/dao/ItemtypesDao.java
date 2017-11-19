package com.dao;

import com.pojo.Itemtypes;
import com.pojo.Peitems;

import java.util.List;

/**
 * Created by zhangyu on 2017/10/18.
 */
public interface ItemtypesDao {


    public List<Itemtypes> getAll();

    public Itemtypes getItemtypesById(Integer id);


}
