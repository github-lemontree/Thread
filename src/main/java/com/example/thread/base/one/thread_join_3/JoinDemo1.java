package com.example.thread.base.one.thread_join_3;

/**
 * @author ZhangNan
 * @date 2019/11/2 13:25
 */
public class JoinDemo1 {
	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("child threadOne over");
		});

		Thread threadTwo = new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("child threadTwo over");
		});

		threadOne.start();
		threadTwo.start();
		System.out.println("wait all child thread over");
		threadOne.join();
		threadTwo.join();
		System.out.println("all child thread over");
	}
}
