package zy.service.impl;

import org.springframework.stereotype.Service;
import zy.dao.AccountDao;
import zy.pojo.Account;
import zy.service.AccountService;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;


    public List<Account> isLogin(Account account) {
        return accountDao.isLogin(account);
    }

    public Iterator<Account> findAll() {
        return this.accountDao.findAll();
    }

    public void Transfer(Account loginuser, Account goal, Double balance) {
        this.accountDao.Transfer(loginuser,goal,balance);
    }
}
