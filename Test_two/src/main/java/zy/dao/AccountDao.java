package zy.dao;

import zy.pojo.Account;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
public interface AccountDao {

    public List<Account> isLogin(Account account);

    public Iterator<Account> findAll();

    public void Transfer(Account loginuser,Account goal,Double balance);

}
