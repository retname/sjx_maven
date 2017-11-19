package inter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import java.util.Map;

/**
 * Created by zhangyu on 2017/10/25.
 */
public class LoginInter implements Interceptor{

    public void destroy() {
        System.out.println("拦截器销毁");
    }

    public void init() {
        System.out.println("拦截器初始化");
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();

        String value = "";

        StringBuilder  stringBuilder = new StringBuilder("");
        stringBuilder.append(actionInvocation.getProxy().getNamespace());  //拿到 请求的actionname
        stringBuilder.append(actionInvocation.getProxy().getActionName()); //拿到请求的 namespace  路径
        String usernmae = (String) session.get("username");
        System.out.println(stringBuilder.toString()+"---------------------"+usernmae);

        if(stringBuilder.toString().equals("/interlogin")){
            value = actionInvocation.invoke();
            System.out.println("判断登陆");
        }else if(usernmae!=null){
            System.out.println("判断session");
            value=actionInvocation.invoke();

        }else{

            value="login";
            System.out.println("返回登陆");
        }

        System.out.println(value+"------------------");

        return value;
    }
}
