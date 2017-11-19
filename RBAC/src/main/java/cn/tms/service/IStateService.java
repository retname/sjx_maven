package cn.tms.service;

import cn.tms.dao.IStateDao;
import cn.tms.entity.State;

import java.util.List;

/**
 * Created by zhangyu on 2017/11/8.
 */
public interface IStateService {


    public List<State> findAllState();
}
