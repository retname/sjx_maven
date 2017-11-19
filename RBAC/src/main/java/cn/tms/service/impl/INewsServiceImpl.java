package cn.tms.service.impl;

import cn.tms.dao.INewsDao;
import cn.tms.entity.News;
import cn.tms.service.INewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/8.
 */
@Service
public class INewsServiceImpl implements INewsService {


    @Resource
    private INewsDao iNewsDao;


    public List<News> getAllNews(Map<String, Object> maps) {
        return this.iNewsDao.getAllNews(maps);
    }

    public Integer getNewSize(Map<String, Object> maps) {
        return this.iNewsDao.getNewSize(maps);
    }

    public void delNews(Integer sys_id) {
        this.iNewsDao.delNews(sys_id);
    }

    public void doAddNews(News news) {
        this.iNewsDao.doAddNews(news);
    }

    public News getNewsById(Integer id) {
        return  this.iNewsDao.getNewsById(id);
    }

    public void upNewsById(News news) {
        this.iNewsDao.upNewsById(news);
    }


}
