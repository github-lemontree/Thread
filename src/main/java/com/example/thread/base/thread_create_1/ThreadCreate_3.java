package com.example.thread.base.thread_create_1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ZhangNan
 * @date 2019/11/2 14:45
 */
public class ThreadCreate_3 {
	public static void main(String[] args) {
		//创建异步任务 FutureTask(implements)-> RunnableFuture(implements)->Runnable
		FutureTask<String> futureTask = new FutureTask<String>(new MyThread3());
		Thread thread = new Thread(futureTask);
		thread.start();
		//等待任务完成,返回结果
		try {
			String s = futureTask.get();
			System.out.println(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class MyThread3 implements Callable{
	@Override
	public String call() throws Exception {
		return "thread create implements Callable";
	}
}
