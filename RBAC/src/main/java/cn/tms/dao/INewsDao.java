package cn.tms.dao;

import cn.tms.entity.News;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/8.
 */
@Repository
public interface INewsDao {


    /**
     * 拿到所有的新闻
     * @return
     */
    public List<News> getAllNews(Map<String,Object> maps);


    /**
     * 拿到新闻的size
     * @return
     */
    public Integer getNewSize(Map<String,Object> maps);


    /**
     * 删除新闻
     * @param sys_id
     */
    public void delNews(Integer sys_id);


    /**
     * 添加新闻
     * @return
     */
    public void  doAddNews(News news);


    /**
     * 根据id获取新闻对象
     * @param id
     */
    News getNewsById(Integer  id);


    /**
     * 修改草稿
     * @param news
     */
    void upNewsById(News news);

}
