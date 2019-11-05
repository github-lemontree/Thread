package com.example.thread.base.thread_interrupt_6;

/**
 * @author ZhangNan
 * @date 2019/11/5 8:27
 */
public class ThreadInterruptDemo4 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			//中断标记为true退出循环,清除中断标记
			while(!Thread.currentThread().interrupted()){

			}
			System.out.println("thread isInterrupted:" + Thread.currentThread().isInterrupted());
		});
		thread.start();
		thread.interrupt();
		thread.join();
		System.out.println("main is over");
	}
}
