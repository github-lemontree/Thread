package com.example.thread.base.thread_sleep_4;

/**
 * @author ZhangNan
 * @date 2019/11/2 14:03
 */
public class SleepDemo2 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			try {
				System.out.println("thread is in sleep");
				Thread.sleep(5000);
				System.out.println("child is in awaked");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		thread.start();
//		Thread.sleep(2000);
		Thread.sleep(-1);
		//主线程中断子线程(主线程调用thread线程的中断方法 设置中断标记)
		thread.interrupt();
	}

	/**
	 * Thread.sleep(x) 当x为负数的时候,方法会跑出IllegalArgumentException (非法参数异常)
	 */
}
