package com.entity;

import javax.persistence.*;

/**
 * Created by zhangyu on 2017/11/1.
 */
@Entity
@Table(name = "dept")
public class Dept {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptNo;


    @Column
    private String deptName;



    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
