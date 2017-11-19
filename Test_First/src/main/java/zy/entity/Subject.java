package zy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Entity
@Table(name = "subject")
public class Subject implements Serializable {


    @Id
    @GeneratedValue(generator = "sub_id")
    @GenericGenerator(name = "sub_id",strategy = "native")
    private Integer id;


    @Column(name = "title")
    private String title;


    @Column(name = "totalVotes")
    private Integer totalVotes;

    @Column(name = "viewTimes")
    private Integer viewTimes;


    @Column(name = "createDate")
    private Date createDate;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Options.class)
    @JoinColumn(name = "sid")
    private Set<Options> opts = new HashSet<Options>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Options> getOpts() {
        return opts;
    }

    public void setOpts(Set<Options> opts) {
        this.opts = opts;
    }
}
