package com.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhangyu on 2017/10/18.
 */
@Entity
@Table(name = "third_peitems")
public class Peitems implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemid;

    @Column
    private String itemname;

    @Column
    private Integer typeid;

    @Column
    private Integer necessary;

    @Column
    private String ref;

    @Column
    private Double price;

    @Column
    private String info;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Itemtypes.class)
    private Itemtypes its;


    public Itemtypes getItemtypes() {
        return its;
    }

    public void setItemtypes(Itemtypes itemtypes) {
        this.its = itemtypes;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getNecessary() {
        return necessary;
    }

    public void setNecessary(Integer necessary) {
        this.necessary = necessary;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
