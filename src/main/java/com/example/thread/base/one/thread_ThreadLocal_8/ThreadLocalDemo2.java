package com.example.thread.base.one.thread_ThreadLocal_8;

/**
 * @author ZhangNan
 * @date 2019/11/6 7:56
 */
public class ThreadLocalDemo2 {
	/**
	 * 1.ThreadLocal的实现原理
	 * 	Thread 有一个变量threadLocals (类型为ThreadLocalMap)
	 * 	ThreadLocal的get() set remove
	 *
	 */
	public void setDemo(){
		/**
		 * ThreadLocal的set()方法的伪代码
		 * 1.获取当前线程
		 * Thread t= Thread.currentThread();
		 * 2.将当前线程作为key,去查找对应的线程变量,找到则设置
		 * ThreadLocalMap map = getMap(t);
		 * if(map!=null)
		 *    map.set(this,value);
		 * else
		 *    createMap(t,value)
		 */
	}
	public void getDemo(){
		/**
		 * ThreadLocal的get()方法
		 * 1.获取当前线程
		 * Thread t = Thread.currentThread();
		 * 2.获取当前threadLocals变量
		 * ThreadLocalMap map = getMap(t);
		 * if(map !=null)
		 *    ThreadLocalMao.entry e = map.getEntry(this)
		 *    if(e!=null)
		 *       T result = (T)e.value;
		 *       return result;
		 *    //threadLocals位空则初始化当前线程的threadLocals成员变量
		 *       return setInitialValue();
		 */
	}

	/**
	 *总结:每一个线程内部都有一个名为threadLocals的成员变量,该变量的类型为HashMap,其中key为我们定义的ThreadLocal变量的this引用,
	 * value则为我们使用set方法设置的值,每个线程的本地变量存放在线程自己的内存变量ThreadLocals中,如果当前线程一直不消亡,那么这些本地
	 * 变量会一直存在,所以可能导致内存溢出,因此使用完要记得调用ThreadLocal的remove方法删除对应线程的ThreadLocals中的本地变量.
	 */

}
