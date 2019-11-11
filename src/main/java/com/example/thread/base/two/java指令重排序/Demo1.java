package com.example.thread.base.two.java指令重排序;

/**
 * @author ZhangNan
 * @date 2019/11/7 17:36
 */
public class Demo1 {
	public static class ReadThread extends Thread{
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()){
				if(read){
					System.out.println(num+num);
				}
				System.out.println("read thread");
			}
		}
	}

	public static class WriteThread extends Thread{
		@Override
		public void run() {
			//下面2步可能重排序
			num =2;
			read = true;
			System.out.println("writeThread set over");
		}

	}

	private static int num = 0;
	private static boolean read = false;

	public static void main(String[] args) throws InterruptedException {
		ReadThread readThread = new ReadThread();
		readThread.start();
		WriteThread writeThread = new WriteThread();
		writeThread.start();
		Thread.sleep(10);
		readThread.interrupt();
		System.out.println("main is over");
	}
}
