package cn.springAop.singleton;

/**
 * Created by zhangyu on 2017/11/8.
 * 多线程下饿汉的单利模式
 */
public class EagerSingleton {


    /**
     * 对外声明一个对象
     */
    private static EagerSingleton  eagerSingleton = new EagerSingleton();

    /**
     * 使用synchronized关键字加入到方法上
     * @return
     */
    public synchronized  static EagerSingleton getEagerSingleton(){
        return  eagerSingleton;
    }


}
