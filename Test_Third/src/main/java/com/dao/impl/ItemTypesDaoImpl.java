package com.dao.impl;

import com.pojo.Peitems;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.dao.ItemtypesDao;
import com.pojo.Itemtypes;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/18.
 */
@Repository("itemtypesDao")
public class ItemTypesDaoImpl implements ItemtypesDao {


    @Resource
    private SessionFactory sessionFactory;


    public List<Itemtypes> getAll() {
        Session session =this.sessionFactory.getCurrentSession();
        List<Itemtypes> list = session.createQuery("from Itemtypes").list();
        return list;
    }



    public Itemtypes getItemtypesById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Itemtypes itemtypes = session.get(Itemtypes.class, id);
        return itemtypes;
    }
}
