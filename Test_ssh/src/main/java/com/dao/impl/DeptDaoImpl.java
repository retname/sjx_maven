package com.dao.impl;

import com.dao.DeptDao;
import com.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhangyu on 2017/11/1.
 */
@Repository
public class DeptDaoImpl implements DeptDao{


    @Resource
    private SessionFactory sessionFactory;




    public void save(Dept dept) {
        Session currentSession = this.sessionFactory.openSession();
        Transaction tx =  currentSession.beginTransaction();
        try {
            currentSession.save(dept);
            tx.commit();
        }catch (Exception e){
            System.out.println("添加失败");
            tx.rollback();

        }
    }
}
