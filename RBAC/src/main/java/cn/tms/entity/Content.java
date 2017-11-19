package cn.tms.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/7.
 */
public class Content {


    private Integer c_id;

    private String c_name;

    private String c_url;

    private Integer c_parent;

    private String c_icon;

    //子权限集合
    private List<Content> children=new ArrayList<Content>();


    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_url() {
        return c_url;
    }

    public void setC_url(String c_url) {
        this.c_url = c_url;
    }

    public Integer getC_parent() {
        return c_parent;
    }

    public void setC_parent(Integer c_parent) {
        this.c_parent = c_parent;
    }

    public String getC_icon() {
        return c_icon;
    }

    public void setC_icon(String c_icon) {
        this.c_icon = c_icon;
    }

    public List<Content> getChildren() {
        return children;
    }

    public void setChildren(List<Content> children) {
        this.children = children;
    }


}
