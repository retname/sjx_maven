package cn.tms.dao;

import cn.tms.entity.State;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangyu on 2017/11/8.
 */
@Repository
public interface IStateDao {

    public List<State> findAllState();

}
