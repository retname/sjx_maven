package cn.tms.service;

import cn.tms.entity.Content;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyu on 2017/11/7.
 */
public interface IContentService {

    public List<Content> findAllContent();


    public List<Content> findContentForCmb();

}
