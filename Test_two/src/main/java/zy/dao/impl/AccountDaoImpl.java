package zy.dao.impl;

import org.hibernate.*;
import org.springframework.stereotype.Repository;
import zy.dao.AccountDao;
import zy.pojo.Account;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {


    @Resource
    private SessionFactory sessionFactory;

    public List<Account> isLogin(Account account) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Account where account_number=:number and password =:password";
        Query query = session.createQuery(hql);
        query.setParameter("number",account.getAccount_number().trim());
        query.setParameter("password",account.getPassword().trim());
       /* query.setParameter(0,account.getAccount_number());
        query.setParameter(1,account.getPassword());*/
        List<Account> list = query.list();
        return list;
    }



    public Iterator<Account>  findAll(){
        Session session   = this.sessionFactory.openSession();
        Iterator<Account> iterate = session.createQuery("from Account").iterate();
        return iterate;
    }


    /**
     * 转账方法
     */
    public void Transfer(Account loginuser,Account goal,Double balance){
           Session session =this.sessionFactory.getCurrentSession();
           loginuser.setBalance(loginuser.getBalance()-balance);
           goal.setBalance(goal.getBalance()+balance);
           session.merge(loginuser);   //merge()方法将两个持久态的对象合并
           session.merge(goal);
    }


}
