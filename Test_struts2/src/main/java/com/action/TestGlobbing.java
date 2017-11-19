package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zhangyu on 2017/10/23.
 */
public class TestGlobbing extends ActionSupport{




    public String list(){

        System.out.println("执行list方法");

        return "list";
    }


    public String UpdateTest(){

        System.out.println("执行修改方法");

        return "update";
    }




}
