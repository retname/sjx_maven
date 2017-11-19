package cn.springAop.singleton;

/**
 * Created by zhangyu on 2017/11/8.
 * 多线程下实现懒汉单例模式
 */
public class IdlerSingleton {

    public static IdlerSingleton idlerSingleton;


    /**
     * 声明一个无参构造
     */
    public IdlerSingleton(){}

    /**
     * 方法一
     * 创建一个同步的获取单利对象的方法，保证在多线程下可以访问
     * @return
     */
    public static synchronized IdlerSingleton getIdlerSingleton(){
        if(idlerSingleton==null){
            idlerSingleton  = new IdlerSingleton();
        }
        return idlerSingleton;
    }

    /**
     * 方法二
     * 使用双重同步锁，保证在多线程下可以使用单
     * @return
     */
    public static synchronized IdlerSingleton findIdlerSingleton(){
           if(idlerSingleton==null){
               synchronized(IdlerSingleton.class){
                   if(idlerSingleton==null){
                       idlerSingleton = new IdlerSingleton();
                   }
               }
           }
           return idlerSingleton;
    }

}
