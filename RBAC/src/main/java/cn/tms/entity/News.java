package cn.tms.entity;

import java.util.Date;

/**
 * Created by zhangyu on 2017/11/8.
 */
public class News{

    private Integer sys_id;

    private Integer sys_hits;

    private Integer sys_state;

    private String sys_title;

    private Integer sys_column ;

    private Integer sys_weight;

    private String  sys_color;     //标题颜色

    private String sys_file;      //图片地址

    private String sys_keywords;  //关键字

    private String sys_digest;   //摘要


    private String sys_content;   //正文


    private Integer sys_admin;   //管理原id


    public Integer getSys_admin() {
        return sys_admin;
    }

    public void setSys_admin(Integer sys_admin) {
        this.sys_admin = sys_admin;
    }

    public String getSys_digest() {
        return sys_digest;
    }

    public void setSys_digest(String sys_digest) {
        this.sys_digest = sys_digest;
    }

    public String getSys_content() {
        return sys_content;
    }

    public void setSys_content(String sys_content) {
        this.sys_content = sys_content;
    }

    public String getSys_keywords() {
        return sys_keywords;
    }

    public void setSys_keywords(String sys_keywords) {
        this.sys_keywords = sys_keywords;
    }

    public String getSys_file() {
        return sys_file;
    }

    public void setSys_file(String sys_file) {
        this.sys_file = sys_file;
    }

    private Date sys_uptime;

    private State state;   //状态

    private UserInfo userInfo;   //管理yuan

    private Content content;    //栏目


    public Integer getSys_id() {
        return sys_id;
    }

    public void setSys_id(Integer sys_id) {
        this.sys_id = sys_id;
    }

    public String getSys_title() {
        return sys_title;
    }

    public void setSys_title(String sys_title) {
        this.sys_title = sys_title;
    }

    public Integer getSys_column() {
        return sys_column;
    }

    public void setSys_column(Integer sys_column) {
        this.sys_column = sys_column;
    }

    public Integer getSys_weight() {
        return sys_weight;
    }

    public void setSys_weight(Integer sys_weight) {
        this.sys_weight = sys_weight;
    }

    public Integer getSys_hits() {
        return sys_hits;
    }

    public void setSys_hits(Integer sys_hits) {
        this.sys_hits = sys_hits;
    }

    public Integer getSys_state() {
        return sys_state;
    }

    public void setSys_state(Integer sys_state) {
        this.sys_state = sys_state;
    }


    public Date getSys_uptime() {
        return sys_uptime;
    }

    public void setSys_uptime(Date sys_uptime) {
        this.sys_uptime = sys_uptime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public String getSys_color() {
        return sys_color;
    }

    public void setSys_color(String sys_color) {
        this.sys_color = sys_color;
    }
}
