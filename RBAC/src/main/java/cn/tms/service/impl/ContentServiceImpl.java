package cn.tms.service.impl;

import cn.tms.dao.IContentDao;
import cn.tms.entity.Content;
import cn.tms.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/7.
 */
@Service
public class ContentServiceImpl implements IContentService {


    @Resource
    private IContentDao iContentDao;

    public List<Content> findAllContent() {
        return this.iContentDao.findAllContent();
    }

    public List<Content> findContentForCmb() {
        return this.iContentDao.findContentForCmb();
    }
}
