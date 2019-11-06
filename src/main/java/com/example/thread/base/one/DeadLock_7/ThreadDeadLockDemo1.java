package com.example.thread.base.one.DeadLock_7;

/**
 * @author ZhangNan
 * @date 2019/11/5 8:33
 */
public class ThreadDeadLockDemo1 {

	/**
	 * 线程死锁:是指两个或两个以上的线程在执行过程中,
	 * 因争夺资源而造成的互相等待的现象,在无外力作用的情况下,这些线程会一直相互等待
	 *
	 * 死锁产生的条件:
	 * 1.互斥条件
	 * 2.请求并持有条件
	 * 3.不可剥夺条件
	 * 4.环路等待条件
	 */
	private static Object resourceA = new Object();
	private static Object resourceB = new Object();
	public static void main(String[] args) {
		Thread threadA = new Thread(()->{
			synchronized(resourceA){
				System.out.println(Thread.currentThread() + "get ResourceA");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + "waiting get resourceB");
			}
		});
	}
}
