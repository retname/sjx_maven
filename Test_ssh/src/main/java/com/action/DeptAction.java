package com.action;

import com.entity.Dept;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IDeptService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by zhangyu on 2017/11/1.
 */
@Controller("deptAction")
@Namespace("/")
@ParentPackage("struts-default")
@Scope("prototype")
public class DeptAction extends ActionSupport{


    private Dept dept;


    /**
     * @Autowired he @Resource，@Qulifier
     * 只不过@Autowired按byType自动注入，而@Resource默认按 byName自动注入
     * 所以@Autowired 一般和 @Qualifier配合使用，@Qualifier更有针对性的指出要自动装配的bean
     * @Repository、@Service、@Controller 和 @Component 将类标识为Bean
     */

    @Resource
    private IDeptService iDeptService;


    @Action(value = "add",results = {@Result(name = "success",location = "/jsp/index.jsp")})
    public String saveDept(){
        System.out.println("执行添加方法-----");
        this.iDeptService.save(dept);
        return "success";
    }


    public IDeptService getiDeptService() {
        return iDeptService;
    }

    public void setiDeptService(IDeptService iDeptService) {
        this.iDeptService = iDeptService;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
