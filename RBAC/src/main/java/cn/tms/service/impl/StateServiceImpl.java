package cn.tms.service.impl;

import cn.tms.dao.IStateDao;
import cn.tms.entity.State;
import cn.tms.service.IStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/8.
 */
@Service
public class StateServiceImpl implements IStateService{

    @Resource
    private  IStateDao iStateDao;

    public List<State> findAllState() {
        return this.iStateDao.findAllState();
    }
}
