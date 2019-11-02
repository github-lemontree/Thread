package com.example.thread.base.thread_join_3;

/**
 * @author ZhangNan
 * @date 2019/11/2 13:40
 */
public class JoinDemo2 {
	/**
	 *	主线程调用线程Two的join方法后会被阻塞,当One线程调用了主线成的Interrupt()方法会中断主线程时,主线程会抛出Interruption异常
	 */
	public static void main(String[] args) {
		Thread threadOne = new Thread(()->{
			System.out.println("threadOne begin run!");
			for(;;){

			}
		});
		Thread mainThread = Thread.currentThread();
		Thread threadTwo = new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mainThread.interrupt();
		});

		threadOne.start();
		threadTwo.start();
		try {
			//等待线程One结束
			threadOne.join();
		} catch (InterruptedException e) {
			System.out.println("main thread " + e);
		}

	}
}
