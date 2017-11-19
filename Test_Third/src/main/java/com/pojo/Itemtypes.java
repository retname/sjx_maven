package com.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangyu on 2017/10/18.
 */
@Entity
@Table(name = "third_itemtypes")
public class Itemtypes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer typeid;

    @Column
    private String typename;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "its")
    private Set<Peitems> peitems = new HashSet<Peitems>();


    public Set<Peitems> getPeitems() {
        return peitems;
    }

    public void setPeitems(Set<Peitems> peitems) {
        this.peitems = peitems;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
