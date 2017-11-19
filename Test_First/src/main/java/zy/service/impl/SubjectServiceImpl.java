package zy.service.impl;

import org.springframework.stereotype.Service;
import zy.dao.SubjectDao;
import zy.entity.Subject;
import zy.service.SubjectService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Service("subjectServiceImpl")
public class SubjectServiceImpl implements SubjectService{



    @Resource
    private SubjectDao subjectDao;


    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    public void doTimes(Integer id) {
         this.subjectDao.doTimes(id);
    }

    public void doVote(Integer subId, Integer optid) {
         this.subjectDao.doVote(subId,optid);
    }
}
