package cn.tms.service;

import cn.tms.entity.News;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/8.
 */
public interface INewsService {

    /**
     * 拿到所有的新闻
     * @return
     */
    public List<News> getAllNews(Map<String,Object> maps);

    public Integer getNewSize(Map<String,Object> maps);

    public void delNews(Integer sys_id);

    public void  doAddNews(News news);

    News getNewsById(Integer  id);

    void upNewsById(News news);


}
