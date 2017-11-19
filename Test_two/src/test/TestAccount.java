import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zy.pojo.Account;
import zy.service.AccountService;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
public class TestAccount {



    @Test
    public void TestLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hiberanate.xml");
        AccountService serviceImpl = (AccountService) context.getBean("accountServiceImpl");
        Account account = new Account();
        account.setPassword("1234");
        account.setAccount_number("1997021715478695");
        List<Account> login = serviceImpl.isLogin(account);
        Account account1 = login.get(0);
        System.out.println(account1.getStatus());
        System.out.println(login.size());
    }


    @Test
    public void TestFindAll(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hiberanate.xml");
        AccountService serviceImpl = (AccountService) context.getBean("accountServiceImpl");
        Iterator<Account> all = serviceImpl.findAll();
        System.out.println();
        while (all.hasNext()){
            Account account = all.next();
            if("5234698712547852".equals(account.getAccount_number())){
                System.out.println("success");
                break;
            }
        }

    }



}
