package com.example.thread.base.one.thread_wait_2;

/**
 * @author ZhangNan
 * @date 2019/11/2 11:58
 */
public class ThreadWaitDemo {
	public static volatile Object resourceA = new Object();
	public static volatile Object resourceB = new Object();

	public static void main(String[] args) {
		Thread threadA = new Thread(()->{
			try{
				synchronized(resourceA){
					System.out.println("threadA get resourceA lock");
					synchronized(resourceB){
						System.out.println("threadA get resourceB lock");
						//线程A阻塞并释放获取到的resourceA的锁
						System.out.println("threadA release resourceA lock");
						//当前线程调用共享变量wait()方法后只会释放当前共享变量上的锁,如果当前线程还持有其他共享变量的锁是不会释放的
						resourceA.wait();//resourceA对象锁被释放,threadA被挂起
					}
				}
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		});

		Thread threadB = new Thread(()->{
			try{
				Thread.sleep(1000);//确保threadA 早于threadB执行
				//在threadA释放了resourceA对象锁,threadB可以获取到了resourceA对象锁
				synchronized(resourceA){
					System.out.println("threadB get resourceA lock");
					System.out.println("threadB try get resourceB lock");
					synchronized(resourceB){
						System.out.println("threadB get resourceB lock");
						System.out.println("threadB release resourceA lock");
						resourceA.wait();
					}
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		});

		threadA.start();
		threadB.start();
		try {
			//join 等待这个线程结束 是main线程进行休眠进入( TIMED_WAITING 状态),等到该线程结束了,在执行main线程
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main is over");

	}
}
