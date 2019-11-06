package com.example.thread.base.one.thread_interrupt_6;

/**
 * @author ZhangNan
 * @date 2019/11/5 8:07
 */
public class ThreadInterruptDemo2 {
	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(()->{
			try {
				System.out.println("threadOne begin sleep for 2000 seconds");
				Thread.sleep(2000000);
				System.out.println("threadOne awaking");
			} catch (InterruptedException e) {
				System.out.println("threadOne is interrupted while sleeping");
				return;
			}
			System.out.println("threadOne-leaving normally");
		});

		threadOne.start();
		Thread.sleep(1000);
		threadOne.interrupt();
		threadOne.join();
		System.out.println("main is over");
	}
}
