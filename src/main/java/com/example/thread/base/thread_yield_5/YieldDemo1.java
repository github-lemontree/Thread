package com.example.thread.base.thread_yield_5;

/**
 * @author ZhangNan
 * @date 2019/11/2 14:16
 *
 * Thread.yield()方法一般很少使用 在调式或者测试时用个方法
 */
public class YieldDemo1 implements Runnable{

	YieldDemo1(){
		Thread thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		for(int i = 0;i < 5;i++){
			//当i=0时让出cpu执行权,放弃时间片,进行下一轮调度
			if(i%5==0){
				System.out.println(Thread.currentThread() + "yield cpu");

				//当前线程让出cpu执行权,放弃时间片,进行下一轮调度
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread() + " is over");
	}

	public static void main(String[] args) {
		YieldDemo1 yieldDemo1 = new YieldDemo1();
		YieldDemo1 yieldDemo2 = new YieldDemo1();
		YieldDemo1 yieldDemo3 = new YieldDemo1();
	}

	/**
	 * sleep 和yield方法区别
	 * sleep:当线程调用sleep方法时调用线程会被阻塞挂起制定的时间,在期间线程调度器不会去调度该线程.
	 * yield:当线程调用yield方法时,线程只是让出自己cup分配给自己剩余的时间片,并没有被阻塞挂起,处于就绪状态
	 * 		 线程调度器下一次调度时就有可能调度到当前线程执行.
	 */
}
