package zy.pojo;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Entity
@Table(name = "account")
@org.hibernate.annotations.Cache(usage =CacheConcurrencyStrategy.READ_WRITE )
public class Account implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String account_number;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Integer status;

    @Column(name = "balance")
    private double balance;



    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
