package zy.service;

import zy.entity.Subject;

import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
public interface SubjectService {

    public List<Subject> findAll();
    public void doTimes(Integer id);

    public void doVote(Integer subId,Integer optid);
}
