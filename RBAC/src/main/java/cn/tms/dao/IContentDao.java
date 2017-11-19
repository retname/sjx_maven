package cn.tms.dao;

import cn.tms.entity.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangyu on 2017/11/7.
 */
@Repository
public interface IContentDao {


    /**
     * 获取所有的内容
     * @return
     */
    public List<Content> findAllContent();


    /**
     * 根据name获取content
     * @param name
     * @return
     */
    public Content findContentByName(String name);


    /**
     * 获取国内资讯和国际咨询
     * @return
     */
    public List<Content> findContentForCmb();




}
