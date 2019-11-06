package com.example.thread.base.one.thread_ThreadLocal_8;

/**
 * @author ZhangNan
 * @date 2019/11/6 13:50
 */
public class ThreadLocalDemo4 {
	public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) {
		threadLocal.set("test");
		Thread thread = new Thread(()->{
			System.out.println("thread:" + threadLocal.get());
		});
		thread.start();
		System.out.println("main:" + threadLocal.get());
	}

}

