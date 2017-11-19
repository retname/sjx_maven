package zy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import zy.dao.SubjectDao;
import zy.entity.Options;
import zy.entity.Subject;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Repository("subjectDao")
public class SubjectDaoImpl implements SubjectDao {


    @Resource
    private SessionFactory sessionFactory;


    public List<Subject> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List sublist = session.createQuery("from Subject order by createDate asc ").list();
        return sublist;
    }

    public void doTimes(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Subject subject = session.get(Subject.class, id);
        subject.setViewTimes(subject.getViewTimes()+1);
        session.update(subject);
    }

    public void doVote(Integer subId, Integer optid) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = session.get(Subject.class, subId);
        Options options = session.get(Options.class,optid);
        subject.setTotalVotes(subject.getTotalVotes()+1);
        options.setVote(options.getVote()+1);
        session.save(options);
        session.save(subject);
    }
}
