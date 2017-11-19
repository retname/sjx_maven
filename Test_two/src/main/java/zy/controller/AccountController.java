package zy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zy.pojo.Account;
import zy.service.AccountService;
import zy.service.impl.AccountServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Controller
public class AccountController {


    @Resource
    private AccountService accountService;


    @RequestMapping("/islogin")
    public String islogin(Account account, HttpServletRequest request){

        List<Account> login = accountService.isLogin(account);
        if(login.size()>0){
            Account account1 = login.get(0);
            if(account1.getStatus()==0){
              request.setAttribute("error","该账户已冻结");
              return "login";
            }else{
                request.getSession().setAttribute("loginuser",account1);
               return "transfer";
            }
        }else{
            request.setAttribute("error","账号或密码错误");
            return "login";
        }
    }


    @RequestMapping("/transfer.do")
    public String tranSfer(String card,double balance,HttpServletRequest request){
        System.out.println(balance);
        //判断账户是否存在,是否被冻结
        Iterator<Account> all = this.accountService.findAll();
        Account loginuser = (Account)request.getSession().getAttribute("loginuser");
        while (all.hasNext()){
            Account next = all.next();
            if (card.equals(loginuser.getAccount_number())){
                request.setAttribute("error","不能向自己转账");
                request.setAttribute("card",card);
                return "transfer";
            }
            if(card.equals(next.getAccount_number())){
                 if(next.getStatus()==0){
                     request.setAttribute("error","目标账户已被冻结 ");
                     request.setAttribute("card",card);
                     return "transfer";
                 }else{
                     if(loginuser.getBalance()<balance){
                         request.setAttribute("error","账户余额不足");
                         request.setAttribute("card",card);
                         return "transfer";
                     }else{
                         this.accountService.Transfer(loginuser,next,balance);
                         return "success";
                     }
                 }
            }
        }
        request.setAttribute("error","该账户不存在");
        return "transfer";
    }


    @RequestMapping("/goon")
    public String  goon(){
        return "transfer";
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest  request){
        request.setAttribute("loginuser","");
        return "login";
    }


}
