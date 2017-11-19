package com.dao.impl;

import com.dao.PeitemsDao;
import com.pojo.Peitems;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhangyu on 2017/10/19.
 */
@Repository("peitemsDao")
public class PeitemsDaoImpl implements PeitemsDao {

    @Resource
    private SessionFactory sessionFactory;

    public Peitems getPeitemsById(Integer itemid) {
        Session session  = this.sessionFactory.getCurrentSession();
        Peitems peitems = session.get(Peitems.class, itemid);
        return peitems;
    }

    public void saveOrUpdate(Peitems peitems) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(peitems);
        tx.commit();
        session.close();
    }
}
