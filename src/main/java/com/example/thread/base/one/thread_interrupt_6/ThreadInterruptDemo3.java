package com.example.thread.base.one.thread_interrupt_6;

/**
 * @author ZhangNan
 * @date 2019/11/5 8:14
 *
 *    public static boolean interrupted(){
 *    	  //清除中断标记
 *        return currentThread().isInterrupted(true);
 *    }
 */
public class ThreadInterruptDemo3 {
	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(()->{
			for(;;){

			}
		});
		threadOne.start();
		//设置中断标记
		threadOne.interrupt();
		//获取中断标记
		System.out.println("isInterrupted:" + threadOne.isInterrupted());
		System.out.println("isInterrupted:" + Thread.currentThread().isInterrupted());
		//获取中断标记并重置
		System.out.println("isInterrupted:" + threadOne.interrupted());
		//获取中断标志并重置
		System.out.println("isInterrupted:" + Thread.interrupted());
		//获取中断标记
		System.out.println("isInterrupted:"+threadOne.isInterrupted());
		threadOne.join();
		System.out.println("main is over");
	}
}
