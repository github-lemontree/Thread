package com.example.thread.base.one.thread_create_1;

/**
 * @author ZhangNan
 * @date 2019/11/2 14:42
 */
public class threadCreate_1 {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyThread1());
		thread.start();
	}
}

class MyThread1 implements Runnable{
	@Override
	public void run() {
		System.out.println("myTread implements Runnable");
	}
}
