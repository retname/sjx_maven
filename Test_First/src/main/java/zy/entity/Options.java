package zy.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Entity
@Table(name = "options")
public class Options implements Serializable {


    @Id
    @GeneratedValue(generator = "opt_id")
    @GenericGenerator(name = "opt_id",strategy = "native")
    private Integer id;


    @Column(name = "optContent")
    private String optContent;

    @Column(name = "vote")
    private Integer vote;


    @Column(name = "sid")
    private Integer sid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
