package com.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.entity.UserInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by zhangyu on 2017/10/22.
 */
public class loginAction implements Action {


    private UserInfo userInfo;

    public String execute() throws Exception {

        //解耦合方式
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        session1.put("username","张三");
        //耦合的方式
        HttpSession session= ServletActionContext.getRequest().getSession();
        session.setAttribute("uname","李四");
        //将上下文中的数据放入值栈中  就是将session里的或者request里的 东西压入值栈
        //值栈中的数据在前台获取可以直接<s:property value="username"></s:property>   非值栈数据需要向上下文中索取<s:property value="#session.username"></s:property>
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.push(session1);
        valueStack.push(session);



        return SUCCESS;
    }





    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
