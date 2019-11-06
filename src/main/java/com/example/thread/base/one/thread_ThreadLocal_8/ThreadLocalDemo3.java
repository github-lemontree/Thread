package com.example.thread.base.one.thread_ThreadLocal_8;

import java.util.HashMap;

/**
 * @author ZhangNan
 * @date 2019/11/6 12:34
 */
public class ThreadLocalDemo3 {
	//创建线程变量
	public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	public static void main(String[] args) {
		//在主线成设置的,子线程获取不到
		threadLocal.set("test");
		Thread thread = new Thread(()->{
			//子线程输出线程变量的值
			System.out.println("thread:" + threadLocal.get());
		});
		thread.start();
		//主线程出现的线程变量
		System.out.println("main:" + threadLocal.get());
	}

}
