package com.example.thread.base.one.thread_create_1;

/**
 * @author ZhangNan
 * @date 2019/11/2 14:44
 */
public class ThreadCreate_2 extends Thread{
	@Override
	public void run() {
		System.out.println("thread extends Thread");
	}

	public static void main(String[] args) {
		ThreadCreate_2 threadCreat_2 = new ThreadCreate_2();
		threadCreat_2.run();
	}
}
