package com.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/22.
 */
public class TestBookAction implements Action {





    public String execute() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sss");
        UserInfo userInfo1 = new UserInfo();
        userInfo.setUsername("ssss");
        List<UserInfo> arrayList = new ArrayList<UserInfo>();
        arrayList.add(userInfo);
        arrayList.add(userInfo1);
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.push(userInfo);
        //valueStack.getRoot().push(arrayList);
        return SUCCESS;
    }

   /* public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }*/

    /*public List<UserInfo> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<UserInfo> arrayList) {
        this.arrayList = arrayList;
    }*/
}
