package com.example.thread.base.one.thread_sleep_4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangNan
 * @date 2019/11/2 13:54
 */
public class SleepDemo1 {
	//创建一个独占锁
	private static final Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		Thread threadA = new Thread(()->{
			lock.lock();
			try {
				System.out.println("child threadA is in sleep");
				Thread.sleep(10000);
				System.out.println("child threadA is in awaked");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				//释放锁
				lock.unlock();
			}
		});

		Thread threadB = new Thread(()->{
			lock.lock();
			try {
				System.out.println("child threadB is in sleep");
				Thread.sleep(10000);
				System.out.println("child threadB is in awaked");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		});
		threadA.start();
		threadB.start();
	}
}
