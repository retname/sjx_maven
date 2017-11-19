package com.action;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by zhangyu on 2017/10/25.
 */
public class TestInterAction implements Action {



    private String pwd;

    private String username;

    public String execute() throws Exception {

        System.out.println(pwd+"-------------"+username);
        Map<String, Object> session = ActionContext.getContext().getSession();
        if(pwd!=null&&username!=null) {
            if (pwd.equals("1") && username.equals("1")) {
                session.put("username",username);
                System.out.println("login successg");
                return SUCCESS;
            }else{
                return LOGIN;
            }
        }else if(session.get("username")!=null){
            System.out.println("check session");
            return SUCCESS;
        }else{
            System.out.println("return login");
            return  LOGIN;
        }
    }





    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
