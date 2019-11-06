package com.example.thread.base.one.thread_wait_2;


/**
 * @author ZhangNan
 * @date 2019/11/2 12:17
 */
public class WaitNotifyInterrupt {
	public static Object obj = new Object();

	public static void main(String[] args) {
		Thread threadA = new Thread(()->{
			try{
				System.out.println("---begin---");
				//阻塞当前线程
				synchronized(obj){
					obj.wait();//wait(0)等价于wait(0) wait()内部也是调用的wait(0)
				}
				//theadA.Interrupt()跑出InterruptionException,下面的end不输出了
				System.out.println("---end---");
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		});
		threadA.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("---begin interrupt threadA");
		//1.如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），那么线程将立即退出被阻塞状态，并抛出一个InterruptedException异常。仅此而已。
		//2.如果线程处于正常活动状态，那么会将该线程的中断标志设置为 true，仅此而已。被设置中断标志的线程将继续正常运行，不受影响。
		//3.stop是暴力的终止线程
		threadA.interrupt();
//		threadA.stop();
		System.out.println("---end interrupt threadA");
	}
}
